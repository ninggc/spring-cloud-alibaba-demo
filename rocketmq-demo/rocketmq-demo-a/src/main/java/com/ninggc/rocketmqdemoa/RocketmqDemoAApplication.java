package com.ninggc.rocketmqdemoa;

import org.rocketmq.starter.annotation.EnableRocketMQ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRocketMQ
public class RocketmqDemoAApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqDemoAApplication.class, args);
    }

}
