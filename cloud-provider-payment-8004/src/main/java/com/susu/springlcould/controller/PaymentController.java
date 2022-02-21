package com.susu.springlcould.controller;

import com.susu.springcloud.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author sujay
 * @version 22:27 2022/2/19
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String discovery() {
        return "SpringCloud With Zookeeper" + serverPort + "\t" + StringUtils.uuid();
    }


}
