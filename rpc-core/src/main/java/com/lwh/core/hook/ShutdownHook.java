package com.lwh.core.hook;

import com.lwh.common.util.NacosUtil;
import com.lwh.common.util.ThreadPoolFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;

/**
 * 用于手动注销注册到Nacos中的服务
 * @author lwh
 * @date 2021年08月25日
 */
@Slf4j
public class ShutdownHook {


    private final ExecutorService threadPool = ThreadPoolFactory.createDefaultThreadPool("shutdown-hook");
    private static final ShutdownHook shutdownHook = new ShutdownHook();

    public static ShutdownHook getShutdownHook() {
        return shutdownHook;
    }

    public void addClearAllHook() {
        log.info("关闭后将自动注销所有服务");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            NacosUtil.clearRegistry();
            threadPool.shutdown();
        }));
    }
}
