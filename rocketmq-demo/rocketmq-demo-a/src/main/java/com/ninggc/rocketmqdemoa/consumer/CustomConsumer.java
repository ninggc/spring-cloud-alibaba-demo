package com.ninggc.rocketmqdemoa.consumer;

import lombok.extern.slf4j.Slf4j;
import org.rocketmq.starter.annotation.RocketMQListener;
import org.rocketmq.starter.annotation.RocketMQMessage;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQListener(topic = "topic-1")
public class CustomConsumer {

    @RocketMQMessage(messageClass = String.class, tag = "tag-1")
    public void onMessage(String message) {
        log.info("received message: {}", message);
    }
}
