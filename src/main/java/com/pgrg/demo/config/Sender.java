package com.pgrg.demo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pgrg.demo.model.Transactions;
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

    @Autowired
    private ObjectMapper objectMapper;

    private String topic="bonus-calculate";

    public void send(String message){
        log.info("Sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }

    public void send(Transactions tx, String topic) throws JsonProcessingException {
        log.info("Sending message='{}' to topic='{}'", tx, topic);
        String str = objectMapper.writeValueAsString(tx);
        kafkaTemplate.send(topic, str);
    }
}
