package com.lwh.core.transport;

import com.lwh.common.entity.RpcRequest;
import com.lwh.core.serializer.CommonSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 客户端接口
 * @author lwh
 * @date 2021年08月24日
 */
public interface RpcClient {

    final static Logger logger = LoggerFactory.getLogger(RpcClient.class);

    Object sendRequest(RpcRequest rpcRequest);

    void setSerializer(CommonSerializer serializer);
}

