package com.lwh.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 判断是请求包还是响应包
 * @author lwh
 * @date 2021年08月25日
 */
@AllArgsConstructor
@Getter
public enum PackageType {
    REQUEST_PACK(0),
    RESPONSE_PACK(1);

    private final int code;
}
