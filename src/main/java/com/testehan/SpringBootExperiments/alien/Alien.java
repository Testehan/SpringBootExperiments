package com.testehan.SpringBootExperiments.alien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")  // without this, only 1 instance of Alien will be created (singleton), and will be used
// in injection points
public class Alien {

    private long id;
    private String name;
    private String type;

    @Autowired                  // searches by type in the application context to know what to inject
    @Qualifier("zbook")         // since here the field is an interface, we need qualifier to search for the correct class to inject
    private Laptop laptop;

    public Alien(){
        System.out.println("Object created");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void show() {
        System.out.println("Alien " + name + " just showed up :D");
        laptop.displayMonitor();
    }
}
