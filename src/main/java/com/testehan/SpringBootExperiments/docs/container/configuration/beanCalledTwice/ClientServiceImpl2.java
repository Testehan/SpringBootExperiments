package com.testehan.SpringBootExperiments.docs.container.configuration.beanCalledTwice;

public class ClientServiceImpl2 implements ClientService2{

    private ClientDao clientDao;
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public ClientDao getClientDao() {
        return this.clientDao;
    }
}
