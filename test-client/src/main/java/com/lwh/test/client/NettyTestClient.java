package com.lwh.test.client;

import com.lwh.api.HelloObject;
import com.lwh.api.HelloService;
import com.lwh.core.transport.RpcClientProxy;
import com.lwh.core.transport.netty.client.NettyClient;

/**
 * @author lwh
 * @date 2021年08月25日
 */
public class NettyTestClient {
    public static void main(String[] args) {
        NettyClient nettyClient = new NettyClient("127.0.0.1", 9999);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(nettyClient);
        HelloService proxy = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = proxy.hello(object);
        System.out.println(res);
    }
}
