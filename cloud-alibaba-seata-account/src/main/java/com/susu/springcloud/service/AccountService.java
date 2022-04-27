package com.susu.springcloud.service;

import com.susu.springcloud.entity.Result;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {

    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
