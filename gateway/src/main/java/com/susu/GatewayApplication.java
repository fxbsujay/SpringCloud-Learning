package com.susu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // http://localhost:9988/baidu -> https://baidu.com
        routes.route("route_baidu_path",
                r -> r.path("/baidu").uri("https://baidu.com")).build();
        return routes.build();
    }

    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 配置跨域
        // 允许哪些头可以跨域
        corsConfiguration.addAllowedHeader("*");
        // 需要哪些请求可以跨域 get post
        corsConfiguration.addAllowedMethod("*");
        // 允许的请求来源
        corsConfiguration.addAllowedOrigin("*");
        // 允许携带 tok
        corsConfiguration.setAllowCredentials(true);
        source.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsWebFilter(source);
    }

    // 自定义全局过滤器
    @Bean
    public GlobalFilter customFilter() {
        return new AuthGlobalFilter();
    }

    public static void main( String[] args ) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
