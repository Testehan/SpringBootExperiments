package com.testehan.SpringBootExperiments.docs.container.configuration.beanCalledTwice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainBeanCalledTwice {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        // the hashcodes of the client dao service will be equal because the same instance is injected in both of them
        ClientService clientService = ctx.getBean(ClientService.class);
        System.out.println("Hashcode of client dao instance: " + clientService.getClientDao().hashCode());

        ClientService2 clientService2 = ctx.getBean(ClientService2.class);
        System.out.println("Hashcode of client dao instance: " + clientService2.getClientDao().hashCode());
    }
}
