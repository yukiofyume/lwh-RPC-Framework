package com.lwh.common.util;

import com.lwh.common.entity.RpcRequest;
import com.lwh.common.entity.RpcResponse;
import com.lwh.common.enumeration.ResponseCode;
import com.lwh.common.enumeration.RpcError;
import com.lwh.common.exception.RpcException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lwh
 * @date 2021年08月25日
 */
@Slf4j
public class RpcMessageChecker {

    public static final String INTERFACE_NAME = "interfaceName";


    private RpcMessageChecker() {
    }

    public static void check(RpcRequest rpcRequest, RpcResponse rpcResponse) {
        if (rpcResponse == null) {
            log.error("调用服务失败,serviceName:{}", rpcRequest.getInterfaceName());
            throw new RpcException(RpcError.SERVICE_INVOCATION_FAILURE, INTERFACE_NAME + ":" + rpcRequest.getInterfaceName());
        }

        if (!rpcRequest.getRequestId().equals(rpcResponse.getRequestId())) {
            throw new RpcException(RpcError.RESPONSE_NOT_MATCH, INTERFACE_NAME + ":" + rpcRequest.getInterfaceName());
        }

        if (rpcResponse.getStatusCode() == null || !rpcResponse.getStatusCode().equals(ResponseCode.SUCCESS.getCode())) {
            log.error("调用服务失败,serviceName:{},RpcResponse:{}", rpcRequest.getInterfaceName(), rpcResponse);
            throw new RpcException(RpcError.SERVICE_INVOCATION_FAILURE, INTERFACE_NAME + ":" + rpcRequest.getInterfaceName());
        }
    }

}