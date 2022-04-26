package com.susu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sujay
 * @version 13:36 2022/4/25
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Sentinel8401 {

    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401.class,args);
    }

}
