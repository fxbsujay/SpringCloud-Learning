package com.susu.springcloud.service;

import com.susu.springcloud.entity.Order;

public interface OrderService {

    void insert(Order order);

    void update(Order order);
}
