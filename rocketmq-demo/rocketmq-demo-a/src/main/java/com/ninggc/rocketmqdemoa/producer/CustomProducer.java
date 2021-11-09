package com.ninggc.rocketmqdemoa.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomProducer {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

}
