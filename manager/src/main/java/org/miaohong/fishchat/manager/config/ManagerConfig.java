package org.miaohong.fishchat.manager.config;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by haroldmiao on 2015/6/13.
 */
public class ManagerConfig {
    private String configFilePath;
    private ManagerBean managerBean = null;

    public ManagerConfig(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    public String getConfigFilePath() {
        return configFilePath;
    }

    public void setConfigFilePath(String configFilePath) {
        this.configFilePath = configFilePath;
    }


    public ManagerBean getManagerBean() {
        return managerBean;
    }

    public void setManagerBean(ManagerBean managerBean) {
        this.managerBean = managerBean;
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
        managerBean = JSON.parseObject(result, ManagerBean.class);
    }

}
