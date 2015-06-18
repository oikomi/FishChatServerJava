package org.miaohong.fishchat.gateway.server;


import org.miaohong.fishchat.log.Log;

import java.util.List;
import java.util.Random;

/**
 * Created by haroldmiao on 2015/6/12.
 */
public class Util {
    public static String selectMsgServer(List<String> msgServerList) {
        int length = msgServerList.size();
        int index = new Random().nextInt(length);
        return msgServerList.get(index);
    }
}
