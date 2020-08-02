package com.zyx.kafkademo.listen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoListener {

    //声明consumerID为demo，监听topicName为topic.quick.demo的Topic
    @KafkaListener(topics = {"${common.msgTopic}"})
    public void listen(String msgData) {
        log.info("demo receive : "+msgData);
    }
}
