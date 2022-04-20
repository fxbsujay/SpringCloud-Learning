package com.susu.springcloud.service;

import com.susu.springcloud.entity.Payment;

/**
 * @author sujay
 * @version 17:22 2022/4/20
 */
public interface PaymentService {

    /**
     * 新增
     * @param payment 对象
     * @return 条数
     */
    public int save(Payment payment);

    /**
     * 查询
     * @param id id
     * @return Payment
     */
    public Payment info(Long id);
}
