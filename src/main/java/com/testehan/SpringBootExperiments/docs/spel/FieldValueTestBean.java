package com.testehan.SpringBootExperiments.docs.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FieldValueTestBean {

    @Value("#{ systemProperties['user.name'] }")
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }

}
