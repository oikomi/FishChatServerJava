package org.miaohong.fishchat.msgserver.server;

import org.miaohong.fishchat.libnet.api.Api;
import org.miaohong.fishchat.log.Log;
import org.miaohong.fishchat.msgserver.config.MsgServerConfig;

/**
 * Created by haroldmiao on 2015/6/12.
 */
public class MsgServer {



    public static void main(String[] args) {
        MsgServerConfig gc = new MsgServerConfig("../src/main/java/org/miaohong/fishchat/msgserver/config/msgserver.json");
        gc.Unmarshal();
        Log.logger.info("msg server start at " + gc.getMsgServerBean().getPort());
        //Api.Bind(gc.getMsgServerBean().getPort(), new GateWayChannelHandler(gc));
    }
}
