package com.testehan.SpringBootExperiments.docs.container.configuration.importt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public TransferImportService transferImportService(AccountRepository accountRepository) {
        return new TransferImportServiceImpl(accountRepository);
    }
}
