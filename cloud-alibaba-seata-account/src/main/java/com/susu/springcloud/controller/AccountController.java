package com.susu.springcloud.controller;

import com.susu.springcloud.entity.Result;
import com.susu.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author sujay
 * @Description 描述
 * @Date 16:58 2022/4/27
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/decrease")
    Result<Boolean> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId,money);
        return new Result<>(true);
    }


}
