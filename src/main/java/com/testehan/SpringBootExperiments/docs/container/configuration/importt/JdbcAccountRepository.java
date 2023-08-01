package com.testehan.SpringBootExperiments.docs.container.configuration.importt;

public class JdbcAccountRepository implements AccountRepository{

    private final DataSource dataSource;

    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void print() {
        System.out.println("Updating DB via JDBC");
    }
}
