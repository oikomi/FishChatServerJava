package org.miaohong.fishchat.gateway.server;


import org.miaohong.fishchat.gateway.config.prop.GateWayServerProperties;
import org.miaohong.fishchat.transport.common.url.URL;
import org.miaohong.fishchat.transport.netty.server.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author miaohong
 * @date 2017/11/16
 */
@Component
public class GateWayServer implements CommandLineRunner {

    @Autowired
    private GateWayServerProperties gwsProperties;

    private NettyServer nettyServer;

    @Override
    public void run(String... args) throws Exception {
        Optional.ofNullable(gwsProperties.getUrl()).ifPresent((url) -> {
            nettyServer = new NettyServer(URL.valueOf(url));
            nettyServer.open();
        });
    }
}
