package org.miaohong.fishchat.gateway.config;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by haroldmiao on 2015/6/11.
 */

public class GateWayBean {
    private String listen;
    private String logFile;
    private List<String> msgServerList = new ArrayList<String>();

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


    public List<String> getMsgServerList() {
        return msgServerList;
    }

    public void setMsgServerList(List<String> msgServerList) {
        this.msgServerList = msgServerList;
    }
}
