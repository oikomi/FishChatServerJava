package org.miaohong.fishchat.gateway.config.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author miaohong
 * @date 2017/11/16
 */
@Component
@ConfigurationProperties(prefix = "server")
public class GateWayServerProperties {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String url;

}
