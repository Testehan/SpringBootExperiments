package com.testehan.SpringBootExperiments.docs.container.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleConfiguration implements BaseConfig{

    /*
        "To declare a bean, you can annotate a method with the @Bean annotation. You use this method to
        register a bean definition within an ApplicationContext of the type specified as the method’s return
        value. By default, the bean name is the same as the method name."
     */
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
