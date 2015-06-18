package org.miaohong.fishchat.msgserver.server;

import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;

/**
 * Created by haroldmiao on 2015/6/18.
 */
public class MsgServerContainer {
    public MsgServerContainer() {

    }

    private HashMap<String, ChannelHandlerContext> sessionMap = new HashMap<String, ChannelHandlerContext>();

    public HashMap<String, ChannelHandlerContext> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(HashMap<String, ChannelHandlerContext> sessionMap) {
        this.sessionMap = sessionMap;
    }

    // Fixme : race condition
    public void addSession(String cid, ChannelHandlerContext ctx) {
        sessionMap.put(cid, ctx);
    }

}
