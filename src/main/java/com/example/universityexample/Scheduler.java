package com.example.universityexample;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Log4j2
public class Scheduler {

    @Scheduled(fixedRate = 100000)
    public void randomEvent() {
        log.info("Random number: " + new Random().nextInt(1000));
    }
}
