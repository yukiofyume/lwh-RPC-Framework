package com.lwh.test.server;

import com.lwh.core.transport.RpcServer;

/**
 * @author lwh
 * @date 2021年08月24日
 */
public class TestServer {
    public static void main(String[] args) {
        HelloServiceImpl helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }
}
