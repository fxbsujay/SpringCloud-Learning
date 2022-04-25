package com.susu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sujay
 * @version 13:36 2022/4/25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel8401 {

    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401.class,args);
    }

}
