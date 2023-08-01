package com.testehan.SpringBootExperiments.docs.container.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainContainerConfiguration {

    public static void main(String[] args) {
        exampleUsingAConfigurationClass();

//        exampleUsingAListOfComponentClassesOrJSR330Annotated();

//        exampleBuildingTheContainerProgramaticallyWithRegister();

//        exampleBuildingTheContainerUsingScanMethod();
    }

    private static void exampleUsingAConfigurationClass() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ExampleConfiguration.class);
        MyService myService = ctx.getBean(MyService.class);
        System.out.println(myService.getName());

        TransferService transferService = ctx.getBean(TransferService.class);
        System.out.println(transferService.getName());
    }

    private static void exampleUsingAListOfComponentClassesOrJSR330Annotated() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyServiceImpl.class);
        MyService myService = ctx.getBean(MyService.class);
        System.out.println(myService.getName());
    }

    private static void exampleBuildingTheContainerProgramaticallyWithRegister() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyServiceImpl.class);
//        ctx.register(AnyOtherClasses.class);
        ctx.refresh();          // this is important :)
        MyService myService = ctx.getBean(MyService.class);
        System.out.println(myService.getName());
    }

    // if you check the logs after running this method you will a log message like
    // " Identified candidate component class:" where Spring notifies you that it found ExampleConfiguration, from which
    // it will use the @Bean method to create your bean
    private static void exampleBuildingTheContainerUsingScanMethod() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // i want to have the main method only working with beans from this package, not other packages
        ctx.scan("com.testehan.SpringBootExperiments.docs.containerConfiguration");

        ctx.refresh();          // this is important :)
        MyService myService = ctx.getBean(MyService.class);
        System.out.println(myService.getName());
    }
}
