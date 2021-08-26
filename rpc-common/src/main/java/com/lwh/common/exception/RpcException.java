package com.lwh.common.exception;

import com.lwh.common.enumeration.RpcError;

/**
 * 异常处理类
 * @author lwh
 * @date 2021年08月24日
 */
public class RpcException extends RuntimeException {

    public RpcException(RpcError error, String detail) {
        super(error.getMessage() + ": " + detail);
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcException(RpcError error) {
        super(error.getMessage());
    }

}
