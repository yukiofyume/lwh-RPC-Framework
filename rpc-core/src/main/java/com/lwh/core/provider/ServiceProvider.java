package com.lwh.core.provider;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 将服务保存到本地
 */
public interface ServiceProvider {

    static final Logger logger = LoggerFactory.getLogger(ServiceProvider.class);



    <T> void addServiceProvider(T service, String serviceName);

    Object getServiceProvider(String serviceName);
}
