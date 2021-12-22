package com.nttdata.bootcamp.gateway.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class Filter2 implements GlobalFilter, Ordered {
	Logger logger = LoggerFactory.getLogger(Filter1.class);
    @Override    public int getOrder() {
        return 2;
    }
    @Override    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("second pre filter");
        return chain.filter(exchange).then(Mono.fromRunnable(() ->        logger.info("first second filter")
        ));
    }

}
