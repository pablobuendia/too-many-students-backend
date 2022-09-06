package com.pablobuendia.universitymanager.configuration;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
@ConditionalOnProperty(name = "com.pablo.auditing.enabled", havingValue = "true")
public class JpaAuditingConfiguration {
}
