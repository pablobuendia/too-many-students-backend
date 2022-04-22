package com.example.universityexample.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "com.pablo.scheduling.enabled", havingValue = "true")
public class SchedulingConfiguration {

}
