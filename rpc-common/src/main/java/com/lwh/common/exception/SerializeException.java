package com.lwh.common.exception;

/**
 * 序列化异常
 * @author lwh
 * @date 2021年08月24日
 */
public class SerializeException extends RuntimeException{
    public SerializeException(String msg) {
        super(msg);
    }
}
