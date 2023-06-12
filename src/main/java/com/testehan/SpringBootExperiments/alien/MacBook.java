package com.testehan.SpringBootExperiments.alien;

import org.springframework.stereotype.Component;

@Component("macbook")
public class MacBook implements Laptop{
    @Override
    public void displayMonitor() {
        System.out.println("display macbook monitor");
    }
}
