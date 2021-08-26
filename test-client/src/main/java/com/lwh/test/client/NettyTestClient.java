package com.lwh.test.client;

import com.lwh.api.HelloObject;
import com.lwh.api.HelloService;
import com.lwh.core.serializer.ProtobufSerializer;
import com.lwh.core.transport.RpcClient;
import com.lwh.core.transport.RpcClientProxy;
import com.lwh.core.transport.netty.client.NettyClient;

/**
 * @author lwh
 * @date 2021年08月25日
 */
public class NettyTestClient {
    public static void main(String[] args) {
        RpcClient client = new NettyClient();
        client.setSerializer(new ProtobufSerializer());
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }
}