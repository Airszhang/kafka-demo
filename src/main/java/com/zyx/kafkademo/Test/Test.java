package com.zyx.kafkademo.Test;

import com.zyx.kafkademo.KafkaDemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaDemoApplication.class)
public class Test {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @org.junit.Test
    public void test() throws InterruptedException {
        kafkaTemplate.send("topic.quick.demo", "this is my first demo");
        //休眠5秒，为了使监听器有足够的时间监听到topic的数据
        Thread.sleep(5000);
    }

}
