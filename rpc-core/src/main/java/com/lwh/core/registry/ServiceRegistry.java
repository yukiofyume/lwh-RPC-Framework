package com.lwh.core.registry;

/**
 * @author lwh
 * @date 2021年08月24日
 */
public interface ServiceRegistry {
    /**
     * 注册服务信息
     * @param service
     * @param <T>
     */
    <T> void register(T service);

    /**
     * 获取服务信息
     * @param serviceName
     * @return
     */
    Object getService(String serviceName);
}