package org.miaohong.fishchat.server.notify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author miaohong
 * @date 2017/11/27
 */
@SpringBootApplication
@EnableEurekaServer
public class NotifyApp {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(NotifyApp.class);
        app.run(args);

    }

}
