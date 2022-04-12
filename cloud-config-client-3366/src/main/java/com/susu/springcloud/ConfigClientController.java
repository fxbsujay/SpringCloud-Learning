package com.susu.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 需要 post请求刷新  http://localhost:3366/actuator/refresh
 */
@RestController
@RefreshScope
public class ConfigClientController {


    @Value("${config.info}")
    private String configInfo;

    @GetMapping("config")
    public String getConfigInfo() {
        return configInfo;
    }
}
