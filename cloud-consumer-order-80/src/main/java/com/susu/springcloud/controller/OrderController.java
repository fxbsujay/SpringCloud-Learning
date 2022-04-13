package com.susu.springcloud.controller;

import com.susu.springcloud.entity.Payment;
import com.susu.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;

/**
 * @author sujay
 * @version 23:56 2022/2/19
 */
@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderController {

    // public static final String PAYMENT_URL = "http://localhost:8001/payment";

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    public RestTemplate restTemplate;

    @Autowired
    public LoadBalancerClient loadBalancerClient;

    @GetMapping("payment/save")
    public Result<Payment> save(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL ,payment,Result.class);
    }

    @GetMapping("payment/{id}")
    public Result<Payment> get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, Result.class);
    }

    @GetMapping("payment/zipkin")
    public Result<String> zipkin() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", Result.class);
    }

   /* @GetMapping("payment/info/{id}")
    public Result<Payment> info(@PathVariable("id") Long id) {
        loadBalancerClient.execute(PAYMENT_URL + "/payment/" + id, HttpMethod.GET,null,new ParameterizedTypeReference<Result<Payment>>(){})

    }*/

}
