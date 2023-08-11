package com.testehan.SpringBootExperiments.docs.container.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements ApplicationEventPublisherAware {

    @Value("${blocked.addresses}")
    private List<String> blockedList;
    @Autowired
    private ApplicationEventPublisher publisher;

    public void setBlockedList(List<String> blockedList) {
        this.blockedList = blockedList;
    }

    /*
        At configuration time, the Spring container detects that EmailService implements
        ApplicationEventPublisherAware and automatically calls setApplicationEventPublisher().
         In reality, the parameter passed in is the Spring container itself. You are interacting with
         the application context through its ApplicationEventPublisher interface.
    */
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String content) {
        if (blockedList.contains(address)) {
            System.out.println("1.This is processed in thread with id " + Thread.currentThread().getId());
            publisher.publishEvent(new BlockedListEvent(this, address, content));
            System.out.println("2");

        } else {
            // send email...
            System.out.println("Sending email to " + address + " having content \"" + content + "\"");
        }
    }
}
