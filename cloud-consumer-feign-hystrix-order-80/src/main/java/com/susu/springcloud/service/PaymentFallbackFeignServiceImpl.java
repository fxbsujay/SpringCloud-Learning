package com.susu.springcloud.service;

import com.susu.springcloud.entity.Result;
import org.springframework.stereotype.Component;

/**
 * @author sujay
 * @version 17:51 2022/4/4
 */
@Component
public class PaymentFallbackFeignServiceImpl implements PaymentFeignService{

    @Override
    public Result<String> ok(Long id) {
        return new Result<>("--------Fallback__ok");
    }

    @Override
    public Result<String> error(Long id) {
        return new Result<>("--------Fallback__error");
    }
}
