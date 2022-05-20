package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.values.DateReserved;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ReservationDayID;

public class DateUpdated extends DomainEvent {
    private final ReservationDayID reservationDayID;
    private final DateReserved date;

    public DateUpdated(ReservationDayID reservationDayID, DateReserved date) {
        super("recordLabel.recordingSession.dateUpdated");
        this.reservationDayID = reservationDayID;
        this.date = date;
    }

    public ReservationDayID getReservationDayID() {
        return reservationDayID;
    }

    public DateReserved getDate() {
        return date;
    }
}
