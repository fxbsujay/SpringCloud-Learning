package com.susu.springcloud.service.Impl;

import com.susu.springcloud.dao.OrderDao;
import com.susu.springcloud.entity.Order;
import com.susu.springcloud.service.AccountService;
import com.susu.springcloud.service.OrderService;
import com.susu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author sujay
 * @Description 描述
 * @Date 16:20 2022/4/27
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp_order_insert",rollbackFor = Exception.class)
    public void insert(Order order) {

        log.info("----------> 新建订单");
        orderDao.insert(order);

        log.info("----------> 订单微服务开始调用库存服务，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("----------> 订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());

        log.info("----------> 修改订单状态 0 -> 1");
        orderDao.update(order.getUserId(),0);

        log.info("----------> 订单结束");
    }

    @Override
    public void update(Order order) {

    }
}
