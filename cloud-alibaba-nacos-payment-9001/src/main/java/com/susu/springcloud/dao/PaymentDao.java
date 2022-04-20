package com.susu.springcloud.dao;

import com.susu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sujay
 * @version 17:22 2022/4/20
 */
@Mapper
public interface PaymentDao {

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
    public Payment info(@Param("id") Long id);
}
