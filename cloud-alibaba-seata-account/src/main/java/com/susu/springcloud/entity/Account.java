package com.susu.springcloud.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author sujay
 * @Description 描述
 * @Date 17:42 2022/4/27
 */
@Data
public class Account {

    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 总额度
     */
    private BigDecimal total;
    /**
     * 已用额度
     */
    private BigDecimal used;
    /**
     * 剩余可用额度
     */
    private BigDecimal residue;
}
