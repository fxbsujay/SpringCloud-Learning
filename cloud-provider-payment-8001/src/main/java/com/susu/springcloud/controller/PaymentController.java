package com.susu.springcloud.controller;

import com.susu.springcloud.entity.Payment;
import com.susu.springcloud.entity.Result;
import com.susu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author sujay
 * @version 22:27 2022/2/19
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping
    public Result<Integer> save(Payment payment) {

        int result = paymentService.save(payment);
        log.info("插入结果:{}",result);

        if (result < 1) {
            return new Result<Integer>().error();
        }
        return new Result<>(result);
    }

    @GetMapping("{id}")
    public Result<Payment> info(@PathVariable("id") Long id) {
        Payment result = paymentService.info(id);
        log.info("查询结果:{}",result);
        if (result == null) {
            return new Result<Payment>().error();
        }
        return new Result<>(result);
    }


}
