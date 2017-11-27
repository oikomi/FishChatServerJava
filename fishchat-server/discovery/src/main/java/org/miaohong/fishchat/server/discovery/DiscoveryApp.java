package org.miaohong.fishchat.server.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author miaohong
 * @date 2017/11/28
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApp {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(DiscoveryApp.class);
        app.run(args);

    }

}
