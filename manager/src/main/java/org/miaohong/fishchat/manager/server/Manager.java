package org.miaohong.fishchat.manager.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.miaohong.fishchat.libnet.api.Api;
import org.miaohong.fishchat.libnet.frame.FrameConst;
import org.miaohong.fishchat.manager.config.ManagerConfig;

/**
 * Created by haroldmiao on 2015/6/13.
 */
public class Manager {
    private static class ManagerChannelHandler extends ChannelInitializer<SocketChannel> {
        private ManagerConfig mc;

        public ManagerChannelHandler(ManagerConfig mc) {
            this.mc = mc;
        }

        @Override
        protected void initChannel(SocketChannel sc) throws Exception {
            ChannelPipeline pipeline = sc.pipeline();

            pipeline.addLast("frameDecoder",new LengthFieldBasedFrameDecoder(FrameConst.MAX_FRAME_LENGTH,
                    FrameConst.FIELD_OFFSET_LENGTH, FrameConst.HEADER_LENGTH,
                    FrameConst.ADJUSTMENT_LENGTH, FrameConst.STRIP_BYTES_LENGTH));
            pipeline.addLast("frameEncoder", new LengthFieldPrepender(FrameConst.HEADER_LENGTH));
            pipeline.addLast(new ManagerServerHandler(mc));
        }
    }

    public static void main(String[] args) {
        ManagerConfig mc = new ManagerConfig("../src/main/java/org/miaohong/fishchat/manager/config/manager.json");
        mc.Unmarshal();
        Api.Bind(mc.getManagerBean().getPort(), new ManagerChannelHandler(mc));
    }
}
