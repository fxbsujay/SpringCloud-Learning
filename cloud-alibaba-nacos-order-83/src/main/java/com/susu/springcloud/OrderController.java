package com.susu.springcloud;

import com.susu.springcloud.entity.Payment;
import com.susu.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("consumer")
@Slf4j
@RefreshScope
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    public RestTemplate restTemplate;

    @Autowired
    public DiscoveryClient discoveryClient;

    @Value("${aaaa}")
    private String value;

    @Value("${bbbbb}")
    private String bbbbb;

    @GetMapping("payment/{id}")
    public Result<Payment> get(@PathVariable("id") Long id) {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        Result forObject = restTemplate.getForObject(instances
                .get(0).getUri().toString() + "/payment/" + id, Result.class);

        return  forObject;
    }

    @GetMapping
    public String get() {
        return  value + bbbbb;
    }
}
