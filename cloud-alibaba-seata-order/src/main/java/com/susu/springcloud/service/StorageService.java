package com.susu.springcloud.service;

import com.susu.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    Result<Boolean> decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
