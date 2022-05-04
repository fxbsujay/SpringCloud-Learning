package com.susu.springcloud.service;

import com.susu.springcloud.entity.Result;

public class FallbackService implements FeignService{

    @Override
    public Result<String> ok(Long id) {
        return new Result<>("失败");
    }
}
