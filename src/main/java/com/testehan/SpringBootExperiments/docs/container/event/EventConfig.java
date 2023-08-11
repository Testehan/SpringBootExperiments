package com.testehan.SpringBootExperiments.docs.container.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@PropertySource("classpath:application.properties")
@EnableAsync        // needed to have async processing of events in a method annotated with @Async
public class EventConfig {

    // need this to extract the list of blocked email adresses by spliting the string from application.properties
    // into multiple entries by ,
    @Bean
    public ConversionService conversionService() {
        return new DefaultConversionService();
    }

    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
