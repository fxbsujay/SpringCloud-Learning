package com.susu.springcloud;

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
