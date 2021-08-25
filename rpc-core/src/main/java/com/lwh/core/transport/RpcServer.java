package com.lwh.core.transport;


import com.lwh.core.serializer.CommonSerializer;

/**
 * @author lwh
 * @date 2021年08月24日
 */
public interface RpcServer {

    void start();

    <T> void publishService(Object service, Class<T> serviceClass);

    void setSerializer(CommonSerializer serializer);
}

