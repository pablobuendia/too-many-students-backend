package com.pablobuendia.universitymanager.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
@ConditionalOnProperty(name = "com.pablo.caching.enabled", havingValue = "true")
public class EnableCacheConfiguration {

}
