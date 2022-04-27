package com.susu.springcloud.controller;

import com.susu.springcloud.entity.Order;
import com.susu.springcloud.entity.Result;
import com.susu.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author sujay
 * @Description 描述
 * @Date 16:58 2022/4/27
 */
@RestController
@RequestMapping("order")
public class OrderController {


    @Resource
    private OrderService service;
    // http://localhost:2001/order/insert?userId=1&productId=1&count=10&money=100
    @GetMapping("insert")
    public Result<Boolean> insert(Order order) {
        service.insert(order);
        return new Result<>(true);
    }
}
