package com.ninggc.gatewaydemoa.handler;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @description: sentinel的失败处理
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/9/15 17:40
 * @version:v1.0
 */
public class SentinelBlockHandler implements BlockRequestHandler {

    @Override
    public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable t) {
        return null;
    }
}
