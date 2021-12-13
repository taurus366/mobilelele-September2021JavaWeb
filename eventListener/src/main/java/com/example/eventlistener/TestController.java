package com.example.eventlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

    private final ApplicationEventPublisher applicationEventPublisher;

    public TestController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/create-order")
    public String order() {

        OrderCreatedEvent event = new OrderCreatedEvent(this, UUID.randomUUID().toString());

        applicationEventPublisher.publishEvent(event);
        return "test";
    }
}
