package com.testehan.SpringBootExperiments.docs.container.configuration.importt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public AccountRepository accountRepository(DataSource2 dataSource) {
        return new JdbcAccountRepository(dataSource);
    }
}
