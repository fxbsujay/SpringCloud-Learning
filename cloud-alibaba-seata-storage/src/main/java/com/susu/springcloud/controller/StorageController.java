package com.susu.springcloud.controller;

import com.susu.springcloud.entity.Result;
import com.susu.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author sujay
 * @Description 描述
 * @Date 16:58 2022/4/27
 */
@RestController
@RequestMapping("storage")
public class StorageController {


    @Resource
    private StorageService storageService;

    @PostMapping("/decrease")
    public Result<Boolean> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return new Result<>(true);
    }

}
