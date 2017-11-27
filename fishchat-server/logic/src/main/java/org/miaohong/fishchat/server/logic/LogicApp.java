package org.miaohong.fishchat.server.logic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author miaohong
 * @date 2017/11/27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LogicApp {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(LogicApp.class);
        app.run(args);

    }

}
