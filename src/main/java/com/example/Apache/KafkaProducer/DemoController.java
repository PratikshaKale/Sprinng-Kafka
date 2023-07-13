package com.example.Apache.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    KafkaTemplate<Object, String> kafkaTemplate;
    private static final String TOPIC="newTopic";
    @GetMapping("/publish/{message}")
    public String publicMessage(@PathVariable("message") final String message ){
        kafkaTemplate.send(TOPIC, message);
        return "published Successfuly !";
    }
}
