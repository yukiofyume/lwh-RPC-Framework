package com.lwh.core.provider;

import com.lwh.common.enumeration.RpcError;
import com.lwh.common.exception.RpcException;
import io.protostuff.Rpc;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lwh
 * @date 2021年08月25日
 * 默认的服务注册表，保存服务端本地服务
 */
@Slf4j
public class ServiceProviderImpl implements ServiceProvider{


    private static final Map<String, Object> serviceMap = new ConcurrentHashMap<>();

    private static final Set<String> registeredService = ConcurrentHashMap.newKeySet();

    @Override
    public <T> void addServiceProvider(T service) {
        String serviceName = service.getClass().getCanonicalName();
        if (registeredService.contains(serviceName)) return;
        registeredService.add(serviceName);
        Class<?>[] interfaces = service.getClass().getInterfaces();
        if (interfaces.length == 0) {
            throw new RpcException(RpcError.SERVICE_NOT_IMPLEMENT_ANY_INTERFACE);
        }
        for (Class<?> i: interfaces) {
            serviceMap.put(i.getCanonicalName(), service);
        }
        log.info("向接口: {} 注册服务: {}", interfaces, serviceName);
    }

    @Override
    public Object getServiceProvider(String serviceName) {
        Boolean b = serviceMap.containsKey(serviceName);
        Object service = serviceMap.get(serviceName);
        if (service == null) {
            throw new RpcException(RpcError.SERVICE_NOT_FOUND);
        }
        return service;
    }
}
