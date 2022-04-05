package com.susu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <p>Description: http://localhost:9001/hystrix </p>
 * @author sujay
 * @version  18:59 2022/4/4
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixMain9001.class,args);
    }
}
