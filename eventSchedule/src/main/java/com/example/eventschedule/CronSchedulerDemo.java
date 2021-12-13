package com.example.eventschedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class CronSchedulerDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(CronSchedulerDemo.class);

//    @Scheduled(cron = "${schedulers.cron}") - check in application.yml
//    @Scheduled(cron = "*/10 * * * * *") - every 10 second will DO
//    @Scheduled(fixedDelay = 5000 , initialDelay = 10000) - after start spring boot  will wait 10 sec and after that every 5 sec will DO
//    @Scheduled(fixedRate = 5000) - every 5 sec will DO but it won't wait for previous task to complete !
    public void showTimeWithCron() {
    LOGGER.info("Hello , from cron scheduler at {}", LocalDateTime.now());
    }

}
