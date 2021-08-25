package com.lwh.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.io.Serializable;

/**
 * @author lwh
 * @date 2021年08月24日
 */
@Data
@Builder
@AllArgsConstructor
public class RpcRequest implements Serializable {

    public RpcRequest(){}

    /**
     * 待调用接口名称
     */
    private String interfaceName;

    /**
     * 待调用方法名称
     */
    private String methodName;

    /**
     * 待调用方法的参数
     */
    private Object[] parameters;

    /**
     * 待调用方法的参数类型
     */
    private Class<?>[] paramTypes;
}
