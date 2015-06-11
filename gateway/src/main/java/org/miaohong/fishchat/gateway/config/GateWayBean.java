package org.miaohong.fishchat.gateway.config;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by haroldmiao on 2015/6/11.
 */

public class GateWayBean {
    private String listen;
    private String logFile;
    private List<MsgServer> msgServerList = new ArrayList<MsgServer>();

    private static class MsgServer {
        private String msgServer;

        public String getMsgServer() {
            return msgServer;
        }

        public void setMsgServer(String msgServer) {
            this.msgServer = msgServer;
        }
    }

    public String getListen() {
        return listen;
    }

    public void setListen(String listen) {
        this.listen = listen;
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }


    public List<MsgServer> getMsgServerList() {
        return msgServerList;
    }

    public void setMsgServerList(List<MsgServer> msgServerList) {
        this.msgServerList = msgServerList;
    }
}
