package com.susu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author fxbsujay@gmail.com
 * <p>Description: 网关</p>
 * @version 23:25 2022/4/7
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GateWayMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMainApplication.class,args);
    }
}
