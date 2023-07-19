package com.testehan.SpringBootExperiments.alien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpaceShip {

    private Alien[] aliens;

    // You can also instruct Spring to provide all beans of a particular type from the ApplicationContext by
    //adding the @Autowired annotation to a field or method that expects an array of that type
    // the reason why this does not work now, is because at the time the container is started, and this bean gets created,
    // only 1 alien will be created, the other aliens from main method that are created later.
    @Autowired
    public SpaceShip(Alien[] aliens){
        this.aliens = aliens;
    }

    public Alien[] getAliens() {
        return aliens;
    }
}
