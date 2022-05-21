package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ReservationNotified extends DomainEvent {
    private final String notification;

    public ReservationNotified(String notification) {
        super("recordLabel.recordingSession.reservationNotified");
        this.notification = notification;

    }

    public String getNotification() {
        return notification;
    }
}
