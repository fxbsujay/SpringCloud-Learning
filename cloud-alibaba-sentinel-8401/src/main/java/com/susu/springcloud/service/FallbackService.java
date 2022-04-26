package com.susu.springcloud.service;

import com.susu.springcloud.entity.Result;

/**
 * @Author sujay
 * @Description 描述
 * @Date 19:47 2022/4/26
 */
public class FallbackService implements FeignService{

    @Override
    public Result<String> ok(Long id) {
        return new Result<>("失败");
    }
}
