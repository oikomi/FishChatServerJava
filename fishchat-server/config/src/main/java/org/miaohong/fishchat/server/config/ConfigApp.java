package org.miaohong.fishchat.server.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author miaohong
 * @date 2017/11/18
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConfigApp.class);
        app.run(args);
    }
}
