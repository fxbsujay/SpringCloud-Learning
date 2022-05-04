package com.susu.springcloud.service;

/**
 * @author sujay
 * @version 22:23 2022/2/19
 */
public interface PaymentService {

    /**
     * 新增
     * @param payment 对象
     * @return 条数
     */
    public String ok(Long id);

    /**
     * 查询
     * @param id id
     * @return Payment
     */
    public String error(Long id);


    public String paymentCircuitBreaker(Long id);
}
