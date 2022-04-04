package com.susu.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.susu.springcloud.service.PaymentService;
import com.susu.springcloud.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author sujay
 * @version 22:24 2022/2/19
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String ok(Long id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_Ok,id: " + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "errorHandle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String error(Long id) {

        // 运行异常
        // int age = 10/0;
        try {
            // 超时异常
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_error,id: " + id + " 耗时 3 秒钟";
    }

    public String errorHandle(Long id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_error_handle,降级: " + id;
    }

    // 服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = StringUtils.uuid();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }

    public String paymentCircuitBreakerFallback(Long id) {
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }
}
