package org.miaohong.fishchat.msgserver.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.miaohong.fishchat.libnet.api.Api;
import org.miaohong.fishchat.libnet.frame.FrameConst;
import org.miaohong.fishchat.msgserver.config.MsgServerConfig;

/**
 * Created by haroldmiao on 2015/6/12.
 */
public class MsgServer {
    private static final String VERSION = "0.0.2";

    private static class MsgServerChannelHandler extends ChannelInitializer<SocketChannel> {
        private MsgServerConfig mc;
        private MsgServerContainer msc;

        public MsgServerChannelHandler(MsgServerConfig gc) {
            this.mc = gc;
        }

        @Override
        protected void initChannel(SocketChannel sc) throws Exception {
            ChannelPipeline pipeline = sc.pipeline();
            pipeline.addLast("frameDecoder",new LengthFieldBasedFrameDecoder(FrameConst.MAX_FRAME_LENGTH,
                    FrameConst.FIELD_OFFSET_LENGTH, FrameConst.HEADER_LENGTH,
                    FrameConst.ADJUSTMENT_LENGTH, FrameConst.STRIP_BYTES_LENGTH));
            pipeline.addLast("frameEncoder", new LengthFieldPrepender(FrameConst.HEADER_LENGTH));
            pipeline.addLast(new MsgServerServerHandler(mc));
        }
    }

    public static void main(String[] args) {
        MsgServerConfig mc = new MsgServerConfig("../src/main/java/org/miaohong/fishchat/msgserver/config/msgserver.json");
        mc.Unmarshal();
        Api.Bind(mc.getMsgServerBean().getPort(), new MsgServerChannelHandler(mc));
    }
}
