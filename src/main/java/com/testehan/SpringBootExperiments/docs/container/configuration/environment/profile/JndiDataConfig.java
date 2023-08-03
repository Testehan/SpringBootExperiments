package com.testehan.SpringBootExperiments.docs.container.configuration.environment.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

@Configuration
@Profile("production")
// to be used when the app is in production. If you activate this and run the app it will fail, because "java:comp/env/jdbc/datasource" does not exist
public class JndiDataConfig {

    @Bean(destroyMethod="")
    public DataSource dataSource() throws Exception {
        /*
            As mentioned earlier, with @Bean methods, you typically choose to use
            programmatic JNDI lookups, by using either Spring’s JndiTemplate
            /JndiLocatorDelegate helpers or the straight JNDI InitialContext usage shown
            earlier but not the JndiObjectFactoryBean variant, which would force you to
            declare the return type as the FactoryBean type.
        */
        System.out.println("Inside dataSource from JndiDataConfig");

        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
    }
}
