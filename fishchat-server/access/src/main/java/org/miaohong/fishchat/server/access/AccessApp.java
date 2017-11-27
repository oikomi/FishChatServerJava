package org.miaohong.fishchat.server.access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by miaohong on 2017/11/27.
 */
@SpringBootApplication
public class AccessApp {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(AccessApp.class);
        app.run(args);

    }

}
