package com.susu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sujay
 * @version 23:53 2022/2/19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ZkOrderMain80.class,args);
    }
}
