//package com.pgrg.demo.config;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.listener.BatchLoggingErrorHandler;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@EnableKafka
//@Configuration
//public class ListenerConfig {
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrap_Servers;
//
//    @Bean
//    public Map<String, Object> ConsumerConfigs() {
//        Map<String, Object> prop = new HashMap<>();
//        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_Servers);
//        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        prop.put(ConsumerConfig.GROUP_ID_CONFIG, "batch");
//        prop.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "5");
//        return prop;
//    }
//
//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(ConsumerConfigs());
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        factory.setBatchListener(true);
//        factory.setBatchErrorHandler(new BatchLoggingErrorHandler());
//        return factory;
//    }
//}
