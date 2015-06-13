package org.miaohong.fishchat.libnet.protocol;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by haroldmiao on 2015/6/12.
 */
public class CmdSimple implements Serializable {
    private String CmdName;
    private ArrayList<String> Args = new ArrayList<String>();

    public CmdSimple() {

    }

    public CmdSimple(String cmdName) {
        this.CmdName = cmdName;
    }

    public String getCmdName() {
        return CmdName;
    }

    public void setCmdName(String cmdName) {
        CmdName = cmdName;
    }

    public ArrayList<String> getArgs() {
        return Args;
    }

    public void setArgs(ArrayList<String> args) {
        Args = args;
    }

    @Override
    public String toString() {
        return CmdName + " " + Args;
    }
}
