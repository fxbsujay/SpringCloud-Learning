package com.susu.springcloud.service;

import com.susu.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-sentinel-service",fallback = FallbackService.class)
public interface FeignService {

    @GetMapping("/payment/ok/{id}")
    public Result<String> ok(@PathVariable("id") Long id);
}
