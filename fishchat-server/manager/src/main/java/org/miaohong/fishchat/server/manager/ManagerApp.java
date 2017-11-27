package org.miaohong.fishchat.server.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by miaohong on 2017/11/27.
 */
@SpringBootApplication
public class ManagerApp {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(ManagerApp.class);
        app.run(args);

    }

}
