package com.susu.springcloud;

import com.susu.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * <p> Description： Ribbon 均衡算法实现 </p>
 * @author sujay
 * @version  10:01 2022/3/25
 */
@SpringBootApplication
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE")
// @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
