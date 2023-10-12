package com.testehan.SpringBootExperiments.docs.aop;

import org.springframework.stereotype.Component;

@Component
public class UserDao{

    public void dataAccessOperation() {
        System.out.println("Making a user DAO");
    }

    public void refresh() {
        System.out.println("Making a user refresh");
    }

    public void getUser(String username) {
        System.out.println("Getting " + username + " from database");
    }

}
