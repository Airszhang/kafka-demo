package com.zyx.kafkademo.Test;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Test2 {

    @Autowired
    @Qualifier("default")
    private KafkaTemplate kafkaTemplate;

    @GetMapping("test")
    public void test() throws InterruptedException {
        kafkaTemplate.send("topic.quick.demo", "this is my first demo");
        //休眠5秒，为了使监听器有足够的时间监听到topic的数据
        Thread.sleep(5000);
    }

    @GetMapping("default")
    public void sendDefault() throws InterruptedException {
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send("topic.quick.demo", "this is my first demo");
        send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("失败");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("success:" + result.getRecordMetadata().toString());
            }
        });

    }

}
