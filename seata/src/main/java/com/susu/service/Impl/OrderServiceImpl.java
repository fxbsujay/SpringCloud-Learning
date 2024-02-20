package com.susu.service.Impl;

import com.susu.action.OrderTccAction;
import com.susu.dao.OrderDao;
import com.susu.entity.Order;
import com.susu.service.OrderService;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Autowired
    private OrderTccAction orderTccAction;

    @Override
    @GlobalLock
    @GlobalTransactional(name = "my_order_insert", rollbackFor = Exception.class)
    public void insert(Order order) {

        log.info("----------> 新建订单");
        orderDao.insert(order);

        // 模拟异常
        // System.out.println(2 / 0);

        log.info("----------> 修改订单状态 0 -> 1");
        orderDao.update(order.getName(),0);

        log.info("----------> 订单结束");
    }

    @Override
    public void save(Order order) {
        orderDao.insert(order);
    }

    @Override
    public Order info(Integer id) {
        return orderDao.info(id);
    }

    @Override
    public void remove(Integer id) {
        orderDao.remove(id);
    }

    @Override
    @GlobalTransactional
    @Transactional
    public void copy(Integer id) {
        Order order = info(id);
        if (order == null) {
            return;
        }
        order.setName(order.getName() + "--Copy");
        orderTccAction.copy(order, order.getId() + 1);

        // 模拟异常
        // System.out.println(2 / 0);
    }
}
