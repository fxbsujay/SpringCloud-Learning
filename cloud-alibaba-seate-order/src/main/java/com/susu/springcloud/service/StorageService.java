package com.susu.springcloud.service;

import com.susu.springcloud.entity.Result;
import com.susu.springcloud.entity.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    Result<Boolean> decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
