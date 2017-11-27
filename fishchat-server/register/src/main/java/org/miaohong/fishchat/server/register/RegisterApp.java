package org.miaohong.fishchat.server.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author miaohong
 * @date 2017/11/27
 */
@SpringBootApplication
public class RegisterApp {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(RegisterApp.class);
        app.run(args);

    }
}
