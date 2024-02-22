package com.susu.controller;

import com.susu.dao.OrderDao;
import com.susu.entity.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderDao service;

    public OrderController(OrderDao service) {
        this.service = service;
    }

    // http://localhost:9990/order/insert
    @GetMapping("insert")
    public ResponseEntity<Boolean> insert() {
        Order order = new Order();
        order.setId(2);
        order.setName("java");
        order.setStatus(1);
        service.insert(order);

        order.setId(1);
        order.setName("python");
        order.setStatus(1);
        service.insert(order);
        return ResponseEntity.ok(true);
    }

}
