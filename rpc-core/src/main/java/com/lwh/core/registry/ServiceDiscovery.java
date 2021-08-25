package com.lwh.core.registry;

import java.net.InetSocketAddress;

/**
 * @author lwh
 * @date 2021年08月25日
 */
public interface ServiceDiscovery {

    InetSocketAddress lookupService(String serviceName);
}
