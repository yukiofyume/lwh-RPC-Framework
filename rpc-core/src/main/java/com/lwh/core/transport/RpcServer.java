package com.lwh.core.transport;


import com.lwh.core.serializer.CommonSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务端接口
 * @author lwh
 * @date 2021年08月24日
 */
public interface RpcServer {

    final static Logger logger = LoggerFactory.getLogger(RpcServer.class);

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    void start();

    <T> void publishService(T service, String serviceName);
}

