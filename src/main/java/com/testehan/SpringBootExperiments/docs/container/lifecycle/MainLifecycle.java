package com.testehan.SpringBootExperiments.docs.container.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainLifecycle {

    public static void main(String[] args) {
        exampleUsingAConfigurationClass();
    }

    private static void exampleUsingAConfigurationClass() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        BeanOne beanOne = ctx.getBean(BeanOne.class);
        BeanTwo beanTwo = ctx.getBean(BeanTwo.class);

    }
}
