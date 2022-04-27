package com.susu.springcloud.entity;

import lombok.Data;

/**
 * @Author sujay
 * @Description 描述
 * @Date 12:58 2022/4/27
 */
@Data
public class Storage {

    private Long id;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 总库存
     */
    private Integer total;
    /**
     * 已用库存
     */
    private Integer used;
    /**
     * 剩余库存
     */
    private Integer residue;
}
