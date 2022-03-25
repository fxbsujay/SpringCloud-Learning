package com.susu.springcloud.controller;

import com.susu.springcloud.entity.Payment;
import com.susu.springcloud.entity.Result;
import com.susu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sujay
 * @version 23:56 2022/2/19
 */
@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderController {

    @Autowired
    public PaymentFeignService service;

    @GetMapping("payment/{id}")
    public Result<Payment> get(@PathVariable("id") Long id) {
        return service.info(id);
    }


}
