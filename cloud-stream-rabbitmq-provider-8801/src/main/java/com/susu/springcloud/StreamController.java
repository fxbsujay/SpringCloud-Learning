package com.susu.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.MediaType;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class StreamController {

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("send")
    public String send() {
        streamBridge.send("studyExchange",  MessageBuilder.withPayload(UUID.randomUUID().toString())
                .build(), MediaType.APPLICATION_JSON);
        return "成功";
    }
}
