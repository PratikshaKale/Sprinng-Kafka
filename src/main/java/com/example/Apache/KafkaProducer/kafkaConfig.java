package com.example.Apache.KafkaProducer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class kafkaConfig {
    @Bean
    public ProducerFactory<String , Book> producerFactory(){
        Map<String, Object> config=new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhostUr;");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG , StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG , JsonSerialize.class);

        return new DefaultKafkaProducerFactory<>(config);
    }
    @Bean
    public KafkaTemplate kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
