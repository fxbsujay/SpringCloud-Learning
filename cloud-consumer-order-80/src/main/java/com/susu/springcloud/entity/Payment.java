package com.susu.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sujay
 * @version 21:55 2022/2/19
 */
@Data
public class Payment implements Serializable {

    private Long id;

    private String serial;

}
