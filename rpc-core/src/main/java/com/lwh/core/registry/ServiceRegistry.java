package com.lwh.core.registry;

import java.net.InetSocketAddress;

/**
 * @author lwh
 * @date 2021年08月24日
 * 远程注册到 Nacos 服务中心
 */
public interface ServiceRegistry {
    void register(String serviceName, InetSocketAddress inetSocketAddress);
    InetSocketAddress lookupService(String serviceName);
}