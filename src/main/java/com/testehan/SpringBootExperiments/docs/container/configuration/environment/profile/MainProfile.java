package com.testehan.SpringBootExperiments.docs.container.configuration.environment.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainProfile {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("development");
        ctx.register(StandaloneDataConfig.class, JndiDataConfig.class);
        ctx.refresh();


    }
}
