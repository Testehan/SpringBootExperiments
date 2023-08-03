package com.testehan.SpringBootExperiments.docs.container.configuration.environment.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@Profile("development")     // this profile would be used by developers, when they want to use an in memory DB
public class StandaloneDataConfig {

    @Bean
    public DataSource dataSource() {
        System.out.println("Inside dataSource from StandaloneDataConfig");

        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
//                .addScript("classpath:com/bank/config/sql/schema.sql")
//                .addScript("classpath:com/bank/config/sql/test-data.sql")
                .build();
    }
}
