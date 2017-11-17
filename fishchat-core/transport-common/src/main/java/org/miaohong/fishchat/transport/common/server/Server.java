package org.miaohong.fishchat.transport.common.server;

import java.net.InetSocketAddress;
import java.util.Collection;

/**
 * @author miaohong
 * @date 2017/11/16
 */
public interface Server extends Channel {

	/**
	 * isActive
	 *
	 * @return
	 */
	boolean isActive();

	/**
	 * get channels.
	 *
	 * @return channels
	 */
	Collection<Channel> getChannels();

	/**
	 * get channel.
	 *
	 * @param remoteAddress
	 * @return channel
	 */
	Channel getChannel(InetSocketAddress remoteAddress);

}
