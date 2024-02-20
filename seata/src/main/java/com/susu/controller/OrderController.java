package com.susu.controller;

import com.susu.entity.Order;
import com.susu.service.OrderService;
import io.seata.core.model.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService service;

    // http://localhost:9990/order/insert
    @GetMapping("insert")
    public Result<Boolean> insert() {
        Order order = new Order();
        order.setName("新来的订单");
        order.setStatus(0);
        service.insert(order);
        return Result.build(true);
    }

    // http://localhost:9990/order/geneOrder
    @GetMapping("copy/{id}")
    public Result<Boolean> copy(@PathVariable("id") Integer id) {
        service.copy(id);
        return Result.build(true);
    }
}
