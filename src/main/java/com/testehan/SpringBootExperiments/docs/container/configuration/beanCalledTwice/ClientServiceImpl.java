package com.testehan.SpringBootExperiments.docs.container.configuration.beanCalledTwice;

public class ClientServiceImpl implements ClientService{

    private ClientDao clientDao;
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public ClientDao getClientDao() {
        return this.clientDao;
    }
}
