package com.testehan.SpringBootExperiments.docs.container.configuration.environment.propertySource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainPropertySource {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertySourceConfig.class);

        TestBean testBean = ctx.getBean(TestBean.class);
        System.out.println(testBean.getName());
    }
}
