package org.miaohong.fishchat.transport.netty.server;

import org.miaohong.fishchat.transport.common.server.AbstractServer;

/**
 * Created by miaohong on 2017/11/16.
 */
public class NettyServer extends AbstractServer {
    @Override
    public boolean isBound() {
        return false;
    }

    @Override
    public boolean open() {
        return false;
    }

    @Override
    public void close() {

    }

    @Override
    public void close(int timeout) {

    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
