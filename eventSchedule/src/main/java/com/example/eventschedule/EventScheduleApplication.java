package com.example.eventschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventScheduleApplication.class, args);
    }

}
