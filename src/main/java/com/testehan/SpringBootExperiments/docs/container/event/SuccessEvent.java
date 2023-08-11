package com.testehan.SpringBootExperiments.docs.container.event;

import org.springframework.context.ApplicationEvent;

public class SuccessEvent extends ApplicationEvent {

    private String content;

    public SuccessEvent(Object source, String content) {
        super(source);

        this.content=content;
    }

    public String getContent() {
        return content;
    }
}
