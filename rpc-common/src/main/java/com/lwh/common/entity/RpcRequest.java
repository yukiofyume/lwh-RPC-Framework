package com.lwh.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

/**
 * @author lwh
 * @date 2021年08月24日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RpcRequest implements Serializable {

    /**
     * 请求号
     */
    private String requestId;

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
