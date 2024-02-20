package com.susu.action.Impl;

import com.susu.action.OrderTccAction;
import com.susu.entity.Order;
import com.susu.service.OrderService;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderTccActionImpl implements OrderTccAction {

    @Autowired
    private OrderService orderService;

    @Override
    public void copy(Order order, Integer id) {
        orderService.save(order);
        log.info("copy---------------------{}", id);
    }

    @Override
    public boolean commit(BusinessActionContext businessActionContext) {
        Integer id = (Integer)businessActionContext.getActionContext("id");
        log.info("commit---------------------{}", id);
        return true;
    }

    @Override
    public boolean cancel(BusinessActionContext businessActionContext) {
        Integer id = (Integer)businessActionContext.getActionContext("id");
        orderService.remove(id);
        log.info("cancel---------------------{}", id);
        return true;
    }
}
