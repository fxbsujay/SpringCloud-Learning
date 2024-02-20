package com.susu.entity;

import lombok.Data;

@Data
public class Order {

    private Integer id;

    private String name;

    /**
     *  订单状态：0：创建中；1：已完结
     */
    private Integer status;
}

