package com.susu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fxbsujay@gmail.com
 * <p>Description: 网关路由配置</p>
 * @version 23:54 2022/4/7
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // http://localhost:9527/guonei -> https://news.baidu.com/guonei
        routes.route("path_route_susu",
                r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
