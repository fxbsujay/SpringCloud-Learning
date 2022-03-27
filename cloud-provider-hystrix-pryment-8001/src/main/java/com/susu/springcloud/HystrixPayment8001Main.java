package com.susu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author sujay
 * @Description 描述
 * @Date 17:20 2022/3/25
 */
@SpringBootApplication
@EnableEurekaClient
public class HystrixPayment8001Main {

    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001Main.class,args);
    }

}
