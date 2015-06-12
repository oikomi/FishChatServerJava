package org.miaohong.fishchat.msgserver.config;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by haroldmiao on 2015/6/11.
 */

public class MsgServerBean {
    private String localIP;
    private String port;
    private String logFile;
    private String scanDeadSessionTimeout;
    private String scanDeadSessionExpire;
    private String monitorBeatTime;
    private List<String> managerServerList = new ArrayList<>();

    private class Mongo {
        private String addr;
        private String port;
        private String user;
        private String password;

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }
    }

    public String getScanDeadSessionTimeout() {
        return scanDeadSessionTimeout;
    }

    public void setScanDeadSessionTimeout(String scanDeadSessionTimeout) {
        this.scanDeadSessionTimeout = scanDeadSessionTimeout;
    }

    public String getLocalIP() {
        return localIP;
    }

    public void setLocalIP(String localIP) {
        this.localIP = localIP;
    }

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

    public String getScanDeadSessionExpire() {
        return scanDeadSessionExpire;
    }

    public void setScanDeadSessionExpire(String scanDeadSessionExpire) {
        this.scanDeadSessionExpire = scanDeadSessionExpire;
    }

    public String getMonitorBeatTime() {
        return monitorBeatTime;
    }

    public void setMonitorBeatTime(String monitorBeatTime) {
        this.monitorBeatTime = monitorBeatTime;
    }

    public List<String> getManagerServerList() {
        return managerServerList;
    }

    public void setManagerServerList(List<String> managerServerList) {
        this.managerServerList = managerServerList;
    }



}
