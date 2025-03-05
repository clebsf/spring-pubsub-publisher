package com.clebertfigueiredo.springpubsub.controller;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    final private PubSubTemplate pubSubTemplate;

    public MessageController(PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
    }


    @PostMapping("/publish")
    public String publishMessage(@RequestBody String phase) {
        pubSubTemplate.publish("spring-pubsub", phase);
        return "Message published: " + phase;
    }

}
