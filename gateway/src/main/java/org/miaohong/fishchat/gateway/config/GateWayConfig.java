package org.miaohong.fishchat.gateway.config;

import com.alibaba.fastjson.JSONReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by haroldmiao on 2015/6/11.
 */
public class GateWayConfig {
    private String configFilePath;
    private JSONReader reader = null;
    private GateWayBean gateWayBean = null;

    public GateWayConfig(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    public GateWayBean Unmarshal() {
        try {
            reader = new JSONReader(new FileReader(configFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reader.startObject();
        while(reader.hasNext()) {
            //String key = reader.readString();
            GateWayBean gateWayBean = reader.readObject(GateWayBean.class);
            // handle vo ...
            // 处理vo对象，比方说插入数据库，或者获取值做其他业务逻辑功能
        }
        reader.endObject();
        reader.close();

        return gateWayBean;
    }


}
