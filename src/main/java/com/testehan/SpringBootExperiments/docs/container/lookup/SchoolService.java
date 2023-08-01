package com.testehan.SpringBootExperiments.docs.container.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

// we create a singleton bean that uses @Lookup

@Component
public class SchoolService {

    // ... member variables, etc.

    /*
        Note that in StudentServices, we left the getNotification method as a stub.

        This is because Spring overrides the method with a call to beanFactory.getBean(StudentNotification.class),
        so we can leave it empty.

     */
    @Lookup
    public SchoolNotification getNotification() {
        return null;
    }

    // ... getters and setters
}
