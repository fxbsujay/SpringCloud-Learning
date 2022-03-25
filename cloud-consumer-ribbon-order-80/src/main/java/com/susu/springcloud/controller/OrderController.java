package com.susu.springcloud.controller;

import com.susu.springcloud.entity.Payment;
import com.susu.springcloud.entity.Result;
import com.susu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    public RestTemplate restTemplate;

    @GetMapping("payment/{id}")
    public Result<Payment> get(@PathVariable("id") Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/" + id ,Result.class);
    }
}
