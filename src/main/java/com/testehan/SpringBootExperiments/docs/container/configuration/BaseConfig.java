package com.testehan.SpringBootExperiments.docs.container.configuration;

import org.springframework.context.annotation.Bean;

// "You can also use default methods to define beans. This allows composition of bean configurations
// by implementing interfaces with bean definitions on default methods". Keep in mind that for this to work
// it needs to be implemented...and it is in ExampleConfiguration
public interface BaseConfig {

    @Bean
    default TransferServiceImpl transferService() {
        return new TransferServiceImpl();
    }
}
