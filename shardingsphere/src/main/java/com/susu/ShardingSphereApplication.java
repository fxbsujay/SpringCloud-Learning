package com.susu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.susu.dao")
public class ShardingSphereApplication {

    public static void main( String[] args ) {
        SpringApplication.run(ShardingSphereApplication.class, args);
    }
}
