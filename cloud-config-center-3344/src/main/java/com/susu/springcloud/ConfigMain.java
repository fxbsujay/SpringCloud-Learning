package com.susu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigMain {

    // http://localhost:3344/main/application-test.yml

    /**
     * 消息总线 bus 只需要刷新总线  http://localhost:3344/actuator/bus_refresh 其他客户端全部生效
     *
     * 定点通知 http://localhost:3344/actuator/bus_refresh/{destination}
     * destination: cloud-config-center:3355  服务名称 + 端口号
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain.class,args);
    }
}
