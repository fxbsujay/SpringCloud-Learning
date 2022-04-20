package com.susu.springcloud.service.impl;

import com.susu.springcloud.dao.PaymentDao;
import com.susu.springcloud.entity.Payment;
import com.susu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sujay
 * @version 17:22 2022/4/20
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment info(Long id) {
        return paymentDao.info(id);
    }
}
