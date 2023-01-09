package com.pablobuendia.universitymanager.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCreatedListener {

  @Async
  @EventListener
  void handleAsyncUserCreatedEvent(UserCreatedEvent event) {
    log.info("New user {} created at {}", event.name(), event.updated());
    // Email the user...
  }

}
