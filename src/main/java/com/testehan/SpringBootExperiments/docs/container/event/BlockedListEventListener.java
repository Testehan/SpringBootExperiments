package com.testehan.SpringBootExperiments.docs.container.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BlockedListEventListener implements ApplicationListener<BlockedListEvent> {

    public void onApplicationEvent(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println("BlockedListEventListener -> Email adress " + event.getAddress() + " is blocked. The following content can't be sent: " + event.getContent());
    }
}
