package com.susu.springcloud.service;

import com.susu.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Component
@FeignClient(name = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    Result<Boolean> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
