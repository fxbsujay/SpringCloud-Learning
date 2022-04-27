package com.susu.springcloud.service.Impl;

import com.susu.springcloud.dao.AccountDao;
import com.susu.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author sujay
 * @Description 描述
 * @Date 18:52 2022/4/27
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId,money);
    }
}
