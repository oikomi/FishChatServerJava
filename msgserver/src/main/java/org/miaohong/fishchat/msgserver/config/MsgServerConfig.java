package org.miaohong.fishchat.msgserver.config;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by haroldmiao on 2015/6/12.
 */
public class MsgServerConfig {
    private String configFilePath;
    private MsgServerBean msgServerBean = null;

    public MsgServerConfig(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    public MsgServerBean getMsgServerBean() {
        return msgServerBean;
    }

    public void setMsgServerBean(MsgServerBean msgServerBean) {
        this.msgServerBean = msgServerBean;
    }

    public void Unmarshal() {
        FileReader fr = null;
        String result = null;
        try {
            File file = new File(configFilePath);
            fr = new FileReader(file);
            char[] contents = new char[(int) file.length()];
            fr.read(contents, 0, (int) file.length());
            result = new String(contents);
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        msgServerBean = JSON.parseObject(result, MsgServerBean.class);
    }

}
