package com.testehan.SpringBootExperiments.docs.container.configuration.importt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainImport {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);
        // everything wires up across configuration classes...
        TransferImportService transferService = ctx.getBean(TransferImportService.class);
        transferService.transfer(100.00, "A123", "C456");
    }
}
