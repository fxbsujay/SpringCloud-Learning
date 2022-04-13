package com.susu.springcloud.controller;

import com.susu.springcloud.entity.Payment;
import com.susu.springcloud.entity.Result;
import com.susu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sujay
 * @version 22:27 2022/2/19
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping
    public Result<Integer> save(@RequestBody Payment payment) {

        int result = paymentService.save(payment);
        log.info("插入结果:{}",result);

        if (result < 1) {
            return new Result<Integer>().error();
        }
        return new Result<>(result);
    }

    @GetMapping("{id}")
    public Result<Payment> info(@PathVariable("id") Long id) {
        Payment result = paymentService.info(id);
        log.info("查询结果:{}",result);
        if (result == null) {
            return new Result<Payment>().error();
        }
        return new Result<>("查询成功，端口好号：" + serverPort,result);
    }

    @GetMapping("discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info("=====服务名=====：{}",service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("=====服务信息===== 实例名：{},地址: {},端口号：{}",instance.getServiceId(),instance.getHost(),instance.getPort());
        }

        return this.discoveryClient;
    }

    @GetMapping("zipkin")
    public Result<String> zipkin() {
        return new Result<>("查询成功，端口好号：" + serverPort);
    }

}
