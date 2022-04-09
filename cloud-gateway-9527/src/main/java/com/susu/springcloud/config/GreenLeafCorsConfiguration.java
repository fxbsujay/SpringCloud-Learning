package com.susu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author fxbsujay@gmail.com
 */
@Configuration
public class GreenLeafCorsConfiguration {

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
}
