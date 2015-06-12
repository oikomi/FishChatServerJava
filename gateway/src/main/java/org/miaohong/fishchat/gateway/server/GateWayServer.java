package org.miaohong.fishchat.gateway.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.miaohong.fishchat.gateway.config.GateWayConfig;
import org.miaohong.fishchat.libnet.api.Api;
import org.miaohong.fishchat.libnet.frame.FrameConst;
import org.miaohong.fishchat.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by haroldmiao on 2015/6/11.
 */
public class GateWayServer {
    private static class GateWayChannelHandler extends ChannelInitializer<SocketChannel> {
        private GateWayConfig gc;

        public GateWayChannelHandler(GateWayConfig gc) {
            this.gc = gc;
        }

        @Override
        protected void initChannel(SocketChannel sc) throws Exception {
            ChannelPipeline pipeline = sc.pipeline();

            pipeline.addLast("frameDecoder",new LengthFieldBasedFrameDecoder(FrameConst.MAX_FRAME_LENGTH,
                    FrameConst.FIELD_OFFSET_LENGTH, FrameConst.HEADER_LENGTH,
                    FrameConst.ADJUSTMENT_LENGTH, FrameConst.STRIP_BYTES_LENGTH));
            pipeline.addLast("frameEncoder", new LengthFieldPrepender(FrameConst.HEADER_LENGTH));
            pipeline.addLast(new GateWayServerHandler(gc));
        }
    }

    public static void main(String[] args) {
        GateWayConfig gc = new GateWayConfig("../src/main/java/org/miaohong/fishchat/gateway/config/gateway.json");
        gc.Unmarshal();
        Log.logger.info("gateway server start at " + gc.getGateWayBean().getPort());
        Api.Bind(gc.getGateWayBean().getPort(), new GateWayChannelHandler(gc));
    }
}
