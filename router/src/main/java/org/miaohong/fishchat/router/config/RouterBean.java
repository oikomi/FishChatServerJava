package org.miaohong.fishchat.router.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haroldmiao on 2015/6/13.
 */
public class RouterBean {
    private String port;
    private String logFile;
    private String UUID;
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


    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public List<String> getManagerServerList() {
        return managerServerList;
    }

    public void setManagerServerList(List<String> managerServerList) {
        this.managerServerList = managerServerList;
    }
}
