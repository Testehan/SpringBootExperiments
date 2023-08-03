package com.testehan.SpringBootExperiments.docs.container.internationalization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class MainInternationalization {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        String message = context.getMessage("msg.text", null, Locale.US);
        System.out.println(message);

        message = context.getMessage("msg.text", null, Locale.CANADA_FRENCH);
        System.out.println(message);
    }
}
