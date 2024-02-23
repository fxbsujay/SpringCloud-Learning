package com.susu.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.susu.handle.SentinelHandle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sentinel")
public class SentinelController {

    // http://localhost:9990/sentinel/test
    // http://localhost:9991
    @GetMapping("test")
    @SentinelResource(
            value = "test",
            fallback = "fallback",
            blockHandlerClass = SentinelHandle.class,
            blockHandler = "handleException"
    )
    public String insert() {
        return "TEST";
    }

    @GetMapping
    @SentinelResource(value = "testC", blockHandler = "fallback")
    public String testC(@RequestParam("p1") String p1, @RequestParam("p2") String p2) {
        System.out.println(p1);
        System.out.println(p2);
        return "testC";
    }

    public static String fallback() {
        return "异常 失败方法";
    }
}
