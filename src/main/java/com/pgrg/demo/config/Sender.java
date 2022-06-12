package com.pgrg.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    @Value("${kafka.topic.app}")
    private String topic="bonus-calculate";

    public void send(String message){
        log.info("Sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }
}
