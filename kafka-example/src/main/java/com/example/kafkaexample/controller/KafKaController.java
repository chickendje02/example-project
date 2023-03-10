package com.example.kafkaexample.controller;

import com.example.kafkaexample.producer.ProducerMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka-example")
public class KafKaController {

    private ProducerMessage producerMessage;

    public KafKaController(ProducerMessage producerMessage) {
        this.producerMessage = producerMessage;
    }

    @GetMapping("/trigger-producer")
    public ResponseEntity<String> triggerProducer(){
        producerMessage.run();
        return ResponseEntity.ok("TN");
    }
    @GetMapping("/trigger-producer-with-message")
    public ResponseEntity<String> triggerProducerTransaction(@RequestParam String message){
        producerMessage.runWithParam(message);
        return ResponseEntity.ok("TN");
    }
}
