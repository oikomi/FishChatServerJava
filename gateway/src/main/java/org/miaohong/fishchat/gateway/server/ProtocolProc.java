package org.miaohong.fishchat.gateway.server;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import org.miaohong.fishchat.gateway.config.GateWayConfig;
import org.miaohong.fishchat.libnet.protocol.Cmd;
import org.miaohong.fishchat.libnet.protocol.CmdSimple;
import org.miaohong.fishchat.log.Log;

import java.util.ArrayList;

/**
 * Created by haroldmiao on 2015/6/12.
 */
public class ProtocolProc {
    private GateWayConfig gc;

    public ProtocolProc(GateWayConfig gc) {
        this.gc = gc;
    }

    public void procReqMsgServer(ChannelHandlerContext ctx, CmdSimple cmd) {
        Log.logger.info("procReqMsgServer");
        Log.logger.info(cmd.toString());
        ArrayList<String> args = new ArrayList<String>();
        String msgServer = Util.selectMsgServer(gc.getGateWayBean().getMsgServerList());
        CmdSimple respCmd = new CmdSimple(Cmd.SELECT_MSG_SERVER_FOR_CLIENT_CMD);
        args.add(msgServer);
        respCmd.setArgs(args);

        ByteBuf resp = Unpooled.copiedBuffer(JSON.toJSONString(respCmd).getBytes());

        ctx.write(resp);
    }

}
