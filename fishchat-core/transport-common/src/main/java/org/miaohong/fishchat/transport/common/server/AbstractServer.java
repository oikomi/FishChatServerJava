package org.miaohong.fishchat.transport.common.server;

import org.miaohong.fishchat.transport.common.state.ChannelState;

import java.net.InetSocketAddress;
import java.util.Collection;

/**
 * @author miaohong
 * @date 2017/11/16
 */
public abstract class AbstractServer implements Server {

	protected InetSocketAddress localAddress;
	protected InetSocketAddress remoteAddress;

	protected volatile ChannelState state = ChannelState.UNINIT;

	public AbstractServer() {
	}


	@Override
	public InetSocketAddress getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(InetSocketAddress localAddress) {
		this.localAddress = localAddress;
	}

	@Override
	public InetSocketAddress getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(InetSocketAddress remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	@Override
	public Collection<Channel> getChannels() {
//        throw new MotanFrameworkException(this.getClass().getName() + " getChannels() method unsupport " + url);
		return null;
	}

	@Override
	public Channel getChannel(InetSocketAddress remoteAddress) {
//        throw new MotanFrameworkException(this.getClass().getName() + " getChannel(InetSocketAddress) method unsupport " + url);
		return null;

	}
}
