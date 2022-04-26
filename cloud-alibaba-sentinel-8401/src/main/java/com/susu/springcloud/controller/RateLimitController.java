package com.susu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.susu.springcloud.handle.SentinelHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sujay
 * @version 17:22 2022/4/20
 */
@RestController
@RequestMapping("sentinel")
@Slf4j
public class RateLimitController {


    // 资源名称为临时节点，URL为持久
    @GetMapping("testD")
    @SentinelResource(value = "testD",fallback = "fallback",blockHandlerClass = SentinelHandle.class,blockHandler = "handleException")
    public String testD() {
        return "testD";
    }

    public static String fallback() {
        return "异常 失败方法";
    }

}
