package com.typicaldev.simplebudget.configuration;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EventBusConfiguration {

    @Bean
    @Scope("singleton")
    public EventBus eventBus() {
        return new EventBus();
    }
}