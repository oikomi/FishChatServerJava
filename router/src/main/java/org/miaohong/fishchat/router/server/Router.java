package org.miaohong.fishchat.router.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.miaohong.fishchat.libnet.api.Api;
import org.miaohong.fishchat.libnet.frame.FrameConst;
import org.miaohong.fishchat.log.Log;
import org.miaohong.fishchat.router.config.RouterConfig;

/**
 * Created by haroldmiao on 2015/6/13.
 */
public class Router {
    private static class RouterChannelHandler extends ChannelInitializer<SocketChannel> {
        private RouterConfig rc;

        public RouterChannelHandler(RouterConfig rc) {
            this.rc = rc;
        }

        @Override
        protected void initChannel(SocketChannel sc) throws Exception {
            ChannelPipeline pipeline = sc.pipeline();

            pipeline.addLast("frameDecoder",new LengthFieldBasedFrameDecoder(FrameConst.MAX_FRAME_LENGTH,
                    FrameConst.FIELD_OFFSET_LENGTH, FrameConst.HEADER_LENGTH,
                    FrameConst.ADJUSTMENT_LENGTH, FrameConst.STRIP_BYTES_LENGTH));
            pipeline.addLast("frameEncoder", new LengthFieldPrepender(FrameConst.HEADER_LENGTH));
            pipeline.addLast(new RouterServerHandler(rc));
        }
    }

    public static void main(String[] args) {
        RouterConfig rc = new RouterConfig("../src/main/java/org/miaohong/fishchat/router/config/router.json");
        rc.Unmarshal();
        Log.logger.info("msg server start at " + rc.getRouterBean().getPort());
        Api.Bind(rc.getRouterBean().getPort(), new RouterChannelHandler(rc));
    }
}
