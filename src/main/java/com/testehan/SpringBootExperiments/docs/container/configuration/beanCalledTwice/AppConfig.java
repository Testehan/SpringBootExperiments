package com.testehan.SpringBootExperiments.docs.container.configuration.beanCalledTwice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    clientDao() has been called once in clientService1() and once in clientService2(). Since this
    method creates a new instance of ClientDaoImpl and returns it, you would normally expect to have
    two instances (one for each service). That definitely would be problematic: In Spring, instantiated
    beans have a singleton scope by default. This is where the magic comes in: All @Configuration
    classes are subclassed at startup-time with CGLIB. In the subclass, the child method checks the
    container first for any cached (scoped) beans before it calls the parent method and creates a new
    instance.

*/

@Configuration
public class AppConfig {
    @Bean
    public ClientService clientService1() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }
    @Bean
    public ClientService2 clientService2() {
        ClientServiceImpl2 clientService = new ClientServiceImpl2();
        clientService.setClientDao(clientDao());
        return clientService;
    }
    @Bean
    public ClientDao clientDao() {
        return new ClientDaoImpl();
    }
}
