package com.susu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigMain {

    // http://localhost:3344/main/application-test.yml
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain.class,args);
    }
}
