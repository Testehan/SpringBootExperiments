package com.testehan.SpringBootExperiments.docs.container.lookup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@PropertySource("classpath:application.properties")
// Commented line from above because it is not needed
// "Spring Boot configures by default a PropertySourcesPlaceholderConfigurer bean
// that will get properties from application.properties and application.yml files."
public class SchoolConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
