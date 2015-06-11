package org.miaohong.fishchat.gateway.config;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by haroldmiao on 2015/6/11.
 */

public class GateWayBean {
    private String port;
    private String logFile;
    private List<String> msgServerList = new ArrayList<String>();

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
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
