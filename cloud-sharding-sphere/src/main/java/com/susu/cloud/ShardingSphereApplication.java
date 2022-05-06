package com.susu.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fxbsujay@gmail.com
 * <p>Description：ShardingSphere</p>
 * @version 14:21 2022/5/4
 */
@SpringBootApplication
@MapperScan("com.susu.cloud.dao")
public class ShardingSphereApplication {


    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereApplication.class,args);
    }
}
