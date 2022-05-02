package com.example.universitymanager.config;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class WebClientConfigurationTest {

    @Test
    void contextLoads() {

    }

    @TestConfiguration
    public static class WebClientTestConfiguration {
        private static final Logger LOGGER = LoggerFactory.getLogger(WebClientTestConfiguration.class);

        @Bean
        public WebClient getWebClient(final WebClient.Builder builder) {
            WebClient webClient = builder
                    .baseUrl("http://localhost")
                    .build();
            LOGGER.info("WebClient created during Test, using class {}", webClient);
            return webClient;
        }
    }
}
