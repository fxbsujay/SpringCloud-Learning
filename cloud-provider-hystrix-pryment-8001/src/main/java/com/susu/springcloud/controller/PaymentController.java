package com.susu.springcloud.controller;

import com.susu.springcloud.entity.Result;
import com.susu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

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

    @GetMapping("/ok/{id}")
    public Result<String> ok(@PathVariable("id") Long id) {
        String result = paymentService.ok(id);
        log.info("查询结果:{}",result);
        if (result == null) {
            return new Result<String>().error();
        }
        return new Result<>("查询成功，端口好号：" + serverPort,result);
    }

    @GetMapping("/error/{id}")
    public Result<String> error(@PathVariable("id") Long id) {
        String result = paymentService.error(id);
        log.info("查询结果:{}",result);
        if (result == null) {
            return new Result<String>().error();
        }
        return new Result<>("查询成功，端口好号：" + serverPort,result);
    }

    @GetMapping("/breaker/{id}")
    public Result<String> paymentCircuitBreaker(@PathVariable("id") Long id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("查询结果:{}",result);
        return new Result<>(result);
    }

}
