package com.testehan.SpringBootExperiments.docs.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MainAspectOrientedProgramming {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectOrientedProgrammingConfig.class);
        // i want to have the main method only working with beans from this package, not other packages

        UserDao userDao = ctx.getBean(UserDao.class);
        userDao.dataAccessOperation();

        userDao.refresh();

        userDao.getUser("DanTe");

    }

}
