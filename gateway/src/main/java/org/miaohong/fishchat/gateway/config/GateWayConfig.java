package org.miaohong.fishchat.gateway.config;

import com.alibaba.fastjson.JSONReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.alibaba.fastjson.JSON;

/**
 * Created by haroldmiao on 2015/6/11.
 */
public class GateWayConfig {
    private String configFilePath;
    //private JSONReader reader = null;
    private GateWayBean gateWayBean = null;

    public GateWayConfig(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    // TODO not a good idear
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
        gateWayBean = JSON.parseObject(result, GateWayBean.class);

        //System.out.println(gateWayBean);
    }
}
