package com.lwh.core.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;


/**
 * 服务发现
 * @author lwh
 * @date 2021年08月25日
 */
public interface ServiceDiscovery {

    static final Logger logger = LoggerFactory.getLogger(ServiceDiscovery.class);

    InetSocketAddress lookupService(String serviceName);
}
