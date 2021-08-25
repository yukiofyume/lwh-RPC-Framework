package com.lwh.core.transport;

import com.lwh.core.handler.RequestHandler;
import com.lwh.core.registry.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author lwh
 * @date 2021年08月24日
 */
public interface RpcServer {
    void start(int port);
}

