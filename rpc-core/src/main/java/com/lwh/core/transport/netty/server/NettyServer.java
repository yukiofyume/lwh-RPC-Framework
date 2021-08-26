package com.lwh.core.transport.netty.server;

import com.lwh.core.codec.CommonDecoder;
import com.lwh.core.codec.CommonEncoder;
import com.lwh.core.hook.ShutdownHook;
import com.lwh.core.provider.ServiceProviderImpl;
import com.lwh.core.registry.NacosServiceRegistry;
import com.lwh.core.serializer.CommonSerializer;
import com.lwh.core.serializer.KryoSerializer;
import com.lwh.core.transport.AbstractRpcServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;


/**
 * Netty服务端
 *
 * @author lwh
 * @date 2021年08月25日
 */
public class NettyServer extends AbstractRpcServer {

    private final CommonSerializer serializer;

    public NettyServer(String host, int port) {
        this(host, port, DEFAULT_SERIALIZER);
    }

    public NettyServer(String host, int port, Integer serializer) {
        this.host = host;
        this.port = port;
        serviceRegistry = new NacosServiceRegistry();
        serviceProvider = new ServiceProviderImpl();
        this.serializer = CommonSerializer.getByCode(serializer);
        scanServices();
    }

    /**
     * 开启服务
     */
    @Override
    public void start() {
        // 主线程组，用于接收客户端请求
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 从线程组，处理主线程组发过来的任务
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 创建Netty服务器
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    // 基于TCP/IP协议，256是临时存放三次握手的请求队列的长度
                    .option(ChannelOption.SO_BACKLOG, 256)
                    // 保持长连接，这个版本需要使用childOption去设置
//                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // 设置低延迟
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    // 初始化通信管道
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            // 设置编码方式
                            pipeline.addLast(new CommonEncoder(new KryoSerializer()));
                            pipeline.addLast(new CommonDecoder());
                            pipeline.addLast(new NettyServerHandler());
                        }
                    });
            ChannelFuture future = serverBootstrap.bind(host, port).sync();
            ShutdownHook.getShutdownHook().addClearAllHook();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            logger.error("启动服务器时有错误发生：", e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
