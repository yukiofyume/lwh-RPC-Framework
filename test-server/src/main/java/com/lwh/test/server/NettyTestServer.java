package com.lwh.test.server;

import com.lwh.api.HelloService;
import com.lwh.common.annotation.ServiceScan;
import com.lwh.core.serializer.CommonSerializer;
import com.lwh.core.serializer.ProtobufSerializer;
import com.lwh.core.transport.netty.server.NettyServer;

/**
 * @author lwh
 * @date 2021年08月25日
 */
@ServiceScan
public class NettyTestServer {
    public static void main(String[] args) {
        NettyServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        server.start();
    }
}
