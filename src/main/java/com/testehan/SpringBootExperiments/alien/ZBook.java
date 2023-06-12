package com.testehan.SpringBootExperiments.alien;

import org.springframework.stereotype.Component;

@Component("zbook")
public class ZBook implements Laptop{
    @Override
    public void displayMonitor() {
        System.out.println("display zbook monitor");
    }
}
