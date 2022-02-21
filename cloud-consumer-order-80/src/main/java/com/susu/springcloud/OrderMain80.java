package com.susu.springcloud;

import com.susu.springcloud.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;

/**
 * @author sujay
 * @version 23:53 2022/2/19
 */
@SpringBootApplication
@LoadBalancerClients(defaultConfiguration = {MyConfig.class})
public class OrderMain80 {



    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
