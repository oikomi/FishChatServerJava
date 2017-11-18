package org.miaohong.fishchat.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author miaohong
 * @date 2017/11/16
 */
@SpringBootApplication
public class GateWayApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GateWayApp.class);
        app.run(args);
    }
}
