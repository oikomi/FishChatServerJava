package org.miaohong.fishchat.libnet.protocol;

import java.awt.*;
import java.io.Serializable;
import java.util.*;
import java.util.List;

/**
 * Created by haroldmiao on 2015/6/12.
 */
public class CmdSimple implements Serializable {
    private String cmdName;
    private ArrayList args = new ArrayList();

    public CmdSimple() {

    }

    public CmdSimple(String cmdName) {
        cmdName = cmdName;
    }

    public ArrayList getArgs() {
        return args;
    }

    public void setArgs(ArrayList args) {
        args = args;
    }


    public String getCmdName() {
        return cmdName;
    }

    public void setCmdName(String cmdName) {
        cmdName = cmdName;
    }


    @Override
    public String toString() {
        return cmdName + " " + args;
    }
}
