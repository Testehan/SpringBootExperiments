package com.testehan.SpringBootExperiments.docs.resources;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class MainResources {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // i want to have the main method only working with beans from this package, not other packages
        ctx.scan("com.testehan.SpringBootExperiments.docs.resources");
        ctx.refresh();          // this is important :)


        MyBean myService = ctx.getBean(MyBean.class);
        System.out.println(myService.getTemplate().getFilename());


        Scanner input = new Scanner(myService.getTemplate().getFile());
        while (input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }

    }
}
