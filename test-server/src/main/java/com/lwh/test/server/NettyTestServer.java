package com.lwh.test.server;

import com.lwh.api.HelloService;
import com.lwh.core.serializer.ProtobufSerializer;
import com.lwh.core.transport.netty.server.NettyServer;

/**
 * @author lwh
 * @date 2021年08月25日
 */
public class NettyTestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        NettyServer server = new NettyServer("127.0.0.1", 9999);
        server.setSerializer(new ProtobufSerializer());
        server.publishService(helloService, HelloService.class);
    }
}
