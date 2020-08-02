package com.zyx.kafkademo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KafkaTopicBean {
    private String topicName;       // topic 名称
    private Integer partition;      // partition 分区数量
    private Integer replication;    // replication 副本数量
    private String descrbe;
}
