package com.pablobuendia.universitymanager.commons;

import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Scheduler {

  @Scheduled(fixedRate = 100000)
  public void randomEvent() {
    log.info("Random number: " + new Random().nextInt(1000));
  }
}
