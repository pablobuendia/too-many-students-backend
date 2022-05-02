package com.pablobuendia.universitymanager.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Publisher {

    private final ApplicationEventPublisher publisher;

    public void publishEvent(String name) {
        publisher.publishEvent(new UserCreatedEvent(name));
    }
}
