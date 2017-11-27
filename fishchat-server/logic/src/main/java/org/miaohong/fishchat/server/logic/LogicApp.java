package org.miaohong.fishchat.server.logic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by miaohong on 2017/11/27.
 */
@SpringBootApplication
public class LogicApp {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(LogicApp.class);
        app.run(args);

    }

}
