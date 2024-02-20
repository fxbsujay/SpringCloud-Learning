package com.susu.service;


import com.susu.entity.Order;

public interface OrderService {

    Order info(Integer id);

    void insert(Order order);

    void save(Order order);

    void remove(Integer id);

    void copy(Integer id);

}
