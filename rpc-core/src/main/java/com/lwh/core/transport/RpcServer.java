package com.lwh.core.transport;


import com.lwh.core.serializer.CommonSerializer;

/**
 * @author lwh
 * @date 2021年08月24日
 */
public interface RpcServer {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    void start();

    <T> void publishService(T service, String serviceName);
}

