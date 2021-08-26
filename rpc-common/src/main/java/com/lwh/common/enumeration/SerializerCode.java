package com.lwh.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 选择序列化方式
 * @author lwh
 * @date 2021年08月24日
 */
@AllArgsConstructor
@Getter
public enum SerializerCode {
    KRYO(0),
    JSON(1),
    HESSIAN(2),
    PROTOBUF(3);
    private final int code;
}