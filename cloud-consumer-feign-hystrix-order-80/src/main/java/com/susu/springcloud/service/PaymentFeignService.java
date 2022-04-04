package com.susu.springcloud.service;


import com.susu.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFallbackFeignServiceImpl.class)
public interface PaymentFeignService {

    @GetMapping("/payment/ok/{id}")
    public Result<String> ok(@PathVariable("id") Long id);

    @GetMapping("/payment/error/{id}")
    public Result<String> error(@PathVariable("id") Long id);

}
