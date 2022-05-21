package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Address;
import com.recordlabelddd.recordlabelddd.resources.values.StudioID;

public class AvailabilityChangeNotified extends DomainEvent {
    private final String notificationMessage;

    public AvailabilityChangeNotified(String notificationMessage) {
        super("recordLabel.resources.AvailabilityChangeNotified");
        this.notificationMessage = notificationMessage;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }
}
