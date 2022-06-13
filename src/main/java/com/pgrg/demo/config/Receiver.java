package com.pgrg.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class Receiver {

    @KafkaListener(id = "kafka-batch", topics = "bonus-calculate")
    public void receive(@Payload List<String> messages,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

        for (int i = 0; i < messages.size(); i++) {
            log.info("Received message='{}' with partition-offset='{}'", messages.get(i),
                    partitions.get(i) + "-" + offsets.get(i));
        }
        log.info("All batch messages received");
    }
}
