package com.testehan.SpringBootExperiments.docs.container.configuration.importt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfig.class, RepositoryConfig.class})
public class SystemTestConfig {

    @Bean
    public DataSource2 dataSource2() {
        return new DataSource2();
    }
}
