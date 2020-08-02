package com.zyx.kafkademo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class KafkaInitialConfiguration {

    //创建TopicName为topic.quick.initial的Topic并设置分区数为8以及副本数为1
    public NewTopic initialTopic() {
        NewTopic topic = new NewTopic("topic.quick.demo",8, (short) 1 );
        adminClient().createTopics(Arrays.asList(topic));
        return topic;
    }

    public KafkaAdmin kafkaAdmin(){
        Map<String, Object>  props = new HashMap<>();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        return new KafkaAdmin(props);
    }

    public AdminClient adminClient(){
        return AdminClient.create(kafkaAdmin().getConfig());
    }
}
