package org.miaohong.fishchat.transport.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.miaohong.fishchat.transport.common.server.AbstractServer;
import org.miaohong.fishchat.transport.common.state.ChannelState;
import org.miaohong.fishchat.transport.common.url.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;


/**
 * @author miaohong
 * @date 2017/11/16
 */
public class NettyServer extends AbstractServer {

	private static final Logger LOGGER = LoggerFactory.getLogger(NettyServer.class);

	private ServerBootstrap bootstrap;
	private ChannelFuture serverChannel;
	private URL url;

	public NettyServer(URL url) {
		this.url = url;
	}

	@Override
	public synchronized boolean open() {
		if (isAvailable()) {
			LOGGER.warn("NettyServer ServerChannel already Opened");
			return true;
		}

		LOGGER.info("NettyServer ServerChannel start at port [{}]", url);

		initServerBootstrap();

		serverChannel = bootstrap.bind(new InetSocketAddress(url.getHost(), url.getPort()));
		state = ChannelState.ALIVE;

		LOGGER.info("NettyServer ServerChannel finish");

		return state.isAliveState();
	}

	private synchronized void initServerBootstrap() {
		NioEventLoopGroup group = new NioEventLoopGroup();

		try {
			bootstrap = new ServerBootstrap();
			bootstrap.group(group).channel(NioServerSocketChannel.class)
					.localAddress(new InetSocketAddress(url.getHost(), url.getPort()))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						              @Override
						              public void initChannel(SocketChannel ch) throws Exception {
							              ch.pipeline().addLast(
									              new ChannelInboundHandlerAdapter() {
										              @Override
										              public void channelActive(ChannelHandlerContext ctx) throws Exception {
										              }
									              });
						              }
					              }
					);
			ChannelFuture f = bootstrap.bind().sync();
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				group.shutdownGracefully().sync();
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}

	}

	@Override
	public void close() {

	}

	@Override
	public void close(int timeout) {

	}

	@Override
	public boolean isClosed() {
		return state.isCloseState();
	}

	@Override
	public boolean isAvailable() {
		return state.isAliveState();
	}

	@Override
	public boolean isActive() {
		return this.serverChannel != null && this.serverChannel.channel().isActive();
	}

}
