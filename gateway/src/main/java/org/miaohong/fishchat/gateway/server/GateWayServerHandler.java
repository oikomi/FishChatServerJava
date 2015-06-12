package org.miaohong.fishchat.gateway.server;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.miaohong.fishchat.gateway.config.GateWayBean;
import org.miaohong.fishchat.libnet.protocol.Cmd;
import org.miaohong.fishchat.libnet.protocol.CmdSimple;
import org.miaohong.fishchat.log.Log;

import java.io.UnsupportedEncodingException;

/**
 * Created by haroldmiao on 2015/6/11.
 */
public class GateWayServerHandler extends ChannelHandlerAdapter {
    private CmdSimple cmd;
    private ProtocolProc pp;

    public GateWayServerHandler() {
        pp = new ProtocolProc();
    }

    private void parseCmd(ChannelHandlerContext ctx, CmdSimple cmd) {
        if (cmd == null) {
            return;
        }

        switch (cmd.getCmdName()) {
            case Cmd.REQ_MSG_SERVER_CMD:
                Log.logger.info("Cmd.REQ_MSG_SERVER_CMD");
                pp.procReqMsgServer(ctx, cmd);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
//        String body = null;
//
//        try {
//            body = new String(req, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
        //System.out.println(req);

        cmd = JSON.parseObject(req, CmdSimple.class);
        //System.out.println(cmd);

        parseCmd(ctx, cmd);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
