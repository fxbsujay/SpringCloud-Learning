package com.susu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.susu.springcloud.entity.Result;
import com.susu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sujay
 * @version 23:56 2022/2/19
 */
@RestController
@RequestMapping("consumer")
@Slf4j
@DefaultProperties(defaultFallback = "errorGlobalHandle")
public class OrderController {

    @Resource
    public PaymentFeignService service;


    @GetMapping("/ok/{id}")
    public Result<String> ok(@PathVariable("id") Long id) {
        return service.ok(id);
    }

   /* @HystrixCommand(fallbackMethod = "errorHandle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })*/
    @HystrixCommand
    @GetMapping("/error/{id}")
    public Result<String> error(@PathVariable("id") Long id) {
        return service.error(id);
    }

    @GetMapping("/hystrix/error/{id}")
    public Result<String> hystrixError(@PathVariable("id") Long id) {
        return service.error(id);
    }

    public Result<String> errorHandle(Long id) {
        return new Result<>("操作失败！");
    }

    public Result<String> errorGlobalHandle() {
        return new Result<>("全局降级处理！");
    }
}
