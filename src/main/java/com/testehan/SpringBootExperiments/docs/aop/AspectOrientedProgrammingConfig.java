package com.testehan.SpringBootExperiments.docs.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectOrientedProgrammingConfig {

    @Bean
    public UserDao myUserDao() {
        return new UserDao();
    }

    @Bean
    public NotVeryUsefulAspect aspect(){
        return new NotVeryUsefulAspect();
    }
}
