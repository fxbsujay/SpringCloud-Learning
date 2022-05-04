package com.susu.springcloud.entity;

import lombok.Data;

import java.math.BigDecimal;

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
