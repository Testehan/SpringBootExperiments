package com.testehan.SpringBootExperiments.docs.container.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEvent {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // i want to have the main method only working with beans from this package, not other packages
        ctx.scan("com.testehan.SpringBootExperiments.docs.container.event");
        ctx.refresh();          // this is important :)


        EmailService myService = ctx.getBean(EmailService.class);

        myService.sendEmail("dante@x.com","is blocat?");
        myService.sendEmail("dante@x.com","is blocat 2 ?");
        myService.sendEmail("dante@yahoo.com","ar trebui sa fie trimis mailul");
    }
}
