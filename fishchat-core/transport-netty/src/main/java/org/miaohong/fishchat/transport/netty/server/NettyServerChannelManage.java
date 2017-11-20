package org.miaohong.fishchat.transport.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author miaohong
 * @date 2017/11/16
 */
public class NettyServerChannelManage extends ChannelInboundHandlerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(NettyServerChannelManage.class);

	@Getter
	private ConcurrentMap<String, Channel> channels = new ConcurrentHashMap<>();

	private int maxChannel = 0;

	public NettyServerChannelManage(int maxChannel) {
		super();
		this.maxChannel = maxChannel;
	}


	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		Channel channel = ctx.channel();

		String channelKey = getChannelKey((InetSocketAddress) channel.localAddress(),
				(InetSocketAddress) channel.remoteAddress());

		if (channels.size() > maxChannel) {
			// 超过最大连接数限制，直接close连接
			LOGGER.warn("NettyServerChannelManage channelConnected channel size out of limit: limit={} current={}",
					maxChannel, channels.size());

			channel.close();
		} else {
			channels.put(channelKey, channel);
			ctx.fireChannelActive();
		}
	}

	/**
	 * Calls {@link ChannelHandlerContext#fireChannelInactive()} to forward
	 * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
	 *
	 * Sub-classes may override this method to change behavior.
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {

		Channel channel = ctx.channel();

		String channelKey = getChannelKey((InetSocketAddress) channel.localAddress(),
				(InetSocketAddress) channel.remoteAddress());

		channels.remove(channelKey);
		ctx.fireChannelInactive();
	}


	/**
	 * close所有的连接
	 */
	public void close() {
		for (Map.Entry<String, Channel> entry : channels.entrySet()) {
			try {
				Channel channel = entry.getValue();

				if (channel != null) {
					channel.close();
				}
			} catch (Exception e) {
				LOGGER.error("NettyServerChannelManage close channel Error: " + entry.getKey(), e);
			}
		}
	}

	/**
	 * remote address + local address 作为连接的唯一标示
	 *
	 * @param local
	 * @param remote
	 * @return
	 */
	private String getChannelKey(InetSocketAddress local, InetSocketAddress remote) {
		String key = "";
		if (local == null || local.getAddress() == null) {
			key += "null-";
		} else {
			key += local.getAddress().getHostAddress() + ":" + local.getPort() + "-";
		}

		if (remote == null || remote.getAddress() == null) {
			key += "null";
		} else {
			key += remote.getAddress().getHostAddress() + ":" + remote.getPort();
		}

		return key;
	}

}
