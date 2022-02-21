package com.susu.springcloud.controller;

import com.susu.springcloud.entity.Payment;
import com.susu.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sujay
 * @version 23:56 2022/2/19
 */
@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderController {

    // public static final String PAYMENT_URL = "http://localhost:8001/payment";

    public static final String PAYMENT_URL = "http://cloud-provoder-payment";

    @Resource
    public RestTemplate restTemplate;

    @GetMapping
    public String save() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk",String.class);
    }


}
