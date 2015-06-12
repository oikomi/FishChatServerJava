package org.miaohong.fishchat.gateway.server;

import io.netty.channel.ChannelHandlerContext;
import org.miaohong.fishchat.libnet.protocol.CmdSimple;
import org.miaohong.fishchat.log.Log;

/**
 * Created by haroldmiao on 2015/6/12.
 */
public class ProtocolProc {


    public ProtocolProc() {

    }

    public void procReqMsgServer(ChannelHandlerContext ctx, CmdSimple cmd) {
        Log.logger.info("procReqMsgServer");
        Log.logger.info(cmd.toString());
        ctx.write("test");
    }

}
