package com.susu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author sujay
 * @version 17:22 2022/4/20
 */
@RestController
@RequestMapping("sentinel")
@Slf4j
public class SentinelController {


    @GetMapping("testA")
    public String testA() {

        return "testA";
    }

    @GetMapping("testB")
    public String testB() {

        return "testB";
    }

    @GetMapping("testC")
    @SentinelResource(value = "testC",blockHandler = "dealTestC")
    public String testC(@RequestParam("p1") String p1,@RequestParam("p2") String p2) {
        return "testC";
    }

    public String dealTestC(String p1, String p2, BlockException e) {

        return "dealTestC";
    }



}
