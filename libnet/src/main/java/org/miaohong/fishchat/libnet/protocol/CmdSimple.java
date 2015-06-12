package org.miaohong.fishchat.libnet.protocol;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by haroldmiao on 2015/6/12.
 */
public class CmdSimple {
    private String cmdName;
    private List<String> args = new ArrayList<String>();

    public String getCmdName() {
        return cmdName;
    }

    public void setCmdName(String cmdName) {
        this.cmdName = cmdName;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }


    @Override
    public String toString() {
        return cmdName + " " + args;
    }
}
