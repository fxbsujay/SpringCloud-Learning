package com.susu.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelHandle {

    public static String handleException(BlockException e) {
        return "sentinel 失败方法";
    }
}
