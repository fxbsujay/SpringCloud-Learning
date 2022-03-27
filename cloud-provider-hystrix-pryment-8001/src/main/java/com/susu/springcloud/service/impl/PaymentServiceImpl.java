package com.susu.springcloud.service.impl;

import com.susu.springcloud.service.PaymentService;
import org.junit.rules.Timeout;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author sujay
 * @version 22:24 2022/2/19
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    @Override
    public String ok(Long id) {

        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_Ok,id: " + id;
    }

    @Override
    public String error(Long id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_Ok,id: " + id + " 耗时 3 秒钟";
    }
}
