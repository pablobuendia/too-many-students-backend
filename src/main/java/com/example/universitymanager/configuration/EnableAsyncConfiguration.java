package com.example.universitymanager.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@ConditionalOnProperty(name = "com.pablo.async.enabled", havingValue = "true")
public class EnableAsyncConfiguration {
}
