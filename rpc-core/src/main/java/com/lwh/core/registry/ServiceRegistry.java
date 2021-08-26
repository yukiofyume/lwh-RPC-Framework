package com.lwh.core.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * @author lwh
 * @date 2021年08月24日
 * 注册服务
 */
public interface ServiceRegistry {

    static final Logger logger = LoggerFactory.getLogger(ServiceRegistry.class);

    /**
     * 将一个服务注册到注册中心
     * @param serviceName
     * @param inetSocketAddress
     */
    void register(String serviceName, InetSocketAddress inetSocketAddress);
}