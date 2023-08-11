package com.testehan.SpringBootExperiments.docs.container.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BlockedListEventListener2 {

    // one can use this approach instead of the one from BlockedListEventListener
    @EventListener
    public void processBlockedListEvent(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println("BlockedListEventListener2 -> Email adress " + event.getAddress() + " is blocked. The following content can't be sent: " + event.getContent());
    }

    @EventListener
    public SuccessEvent processBlockedListEvent2(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress...
        return new SuccessEvent(event.getSource(), "Fired a SuccessEvent from a method processing a BlockedListEvent");
    }

    @EventListener
    public void processSuccessEvent(SuccessEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println(event.getContent());
    }

    @EventListener
    @Async
    public void processBlockedListEvent3(BlockedListEvent event) throws InterruptedException {
        System.out.println("This is processed in thread with id " + Thread.currentThread().getId());
        Thread.sleep(10000);
    }
}
