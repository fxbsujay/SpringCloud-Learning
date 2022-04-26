package com.susu.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author sujay
 * @Description 描述
 * @Date 18:35 2022/4/26
 */
public class SentinelHandle {

    public static String handleException(BlockException e) {
        return "sentinel 失败方法";
    }
}
