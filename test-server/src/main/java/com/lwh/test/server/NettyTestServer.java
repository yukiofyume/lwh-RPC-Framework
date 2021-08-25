package com.lwh.test.server;

import com.lwh.core.registry.ServiceRegistry;
import com.lwh.core.registry.impl.DefaultServiceRegistryImpl;
import com.lwh.core.transport.netty.server.NettyServer;

/**
 * @author lwh
 * @date 2021年08月25日
 */
public class NettyTestServer {
    public static void main(String[] args) {
        HelloServiceImpl service = new HelloServiceImpl();
        ServiceRegistry registry = new DefaultServiceRegistryImpl();
        registry.register(service);
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(9999);
    }
}
