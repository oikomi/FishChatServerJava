package org.miaohong.fishchat.gateway.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.miaohong.fishchat.gateway.config.GateWayConfig;
import org.miaohong.fishchat.libnet.api.Api;
import org.miaohong.fishchat.libnet.frame.FrameConst;

/**
 * Created by haroldmiao on 2015/6/11.
 */
public class GateWayServer {
    private static class GateWayChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel sc) throws Exception {
            //sc.pipeline().addLast(new GateWayServerHandler());
            ChannelPipeline pipeline = sc.pipeline();

            pipeline.addLast("framedecoder",new LengthFieldBasedFrameDecoder(FrameConst.MAX_FRAME_LENGTH,
                    FrameConst.FIELD_OFFSET_LENGTH, FrameConst.HEADER_LENGTH,
                    FrameConst.ADJUSTMENT_LENGTH, FrameConst.STRIP_BYTES_LENGTH));
            pipeline.addLast(new GateWayServerHandler());
        }
    }

    public static void main(String[] args) {
        GateWayConfig gc = new GateWayConfig("../src/main/java/org/miaohong/fishchat/gateway/config/gateway.json");
        gc.Unmarshal();
        Api.Bind(gc.getGateWayBean().getPort(), new GateWayChannelHandler());
    }

}
