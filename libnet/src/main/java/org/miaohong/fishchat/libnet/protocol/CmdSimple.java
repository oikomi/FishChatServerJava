package org.miaohong.fishchat.libnet.protocol;

import java.awt.*;
import java.io.Serializable;
import java.util.*;
import java.util.List;

/**
 * Created by haroldmiao on 2015/6/12.
 */
public class CmdSimple implements Serializable {
    private String CmdName;
    private ArrayList Args = new ArrayList();

    public CmdSimple() {

    }

    public CmdSimple(String cmdName) {
        CmdName = cmdName;
    }

    public ArrayList getArgs() {
        return Args;
    }

    public void setArgs(ArrayList args) {
        Args = args;
    }


    public String getCmdName() {
        return CmdName;
    }

    public void setCmdName(String cmdName) {
        CmdName = cmdName;
    }


    @Override
    public String toString() {
        return CmdName + " " + Args;
    }
}
