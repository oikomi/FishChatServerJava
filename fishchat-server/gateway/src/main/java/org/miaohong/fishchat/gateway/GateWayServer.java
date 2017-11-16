package org.miaohong.fishchat.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GateWayServer {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GateWayServer.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}
}
