package com.susu.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class MessageController {

    @Bean
    public Consumer<String> studyExchange() {
        return System.out::println;
    }
}
