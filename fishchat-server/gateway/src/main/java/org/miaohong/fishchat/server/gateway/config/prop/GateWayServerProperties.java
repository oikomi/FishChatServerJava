package org.miaohong.fishchat.server.gateway.config.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author miaohong
 * @date 2017/11/16
 */
@Configuration
public class GateWayServerProperties {

    @Getter
    @Setter
    @Value("${server.name}")
    private String name;


    @Getter
    @Setter
    @Value("${server.url}")
    private String url;

}
