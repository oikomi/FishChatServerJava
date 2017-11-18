package org.miaohong.fishchat.transport.common.server;

import java.net.InetSocketAddress;

/**
 * @author miaohong
 * @date 2017/11/16
 */
public interface Channel {

    /**
     * get local socket address.
     *
     * @return local address.
     */
    InetSocketAddress getLocalAddress();

    /**
     * get remote socket address
     *
     * @return
     */
    InetSocketAddress getRemoteAddress();


    /**
     * open the channel
     *
     * @return
     */
    boolean open();

    /**
     * close the channel.
     */
    void close();

    /**
     * close the channel gracefully.
     */
    void close(int timeout);

    /**
     * is closed.
     *
     * @return closed
     */
    boolean isClosed();

    /**
     * the node available status
     *
     * @return
     */
    boolean isAvailable();

}
