package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.values.DateReserved;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PaymentAdvance;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ReservationDayID;

public class ReservationDayAdded extends DomainEvent {
    private final ReservationDayID reservationDayID;
    private final DateReserved date;
    private final PaymentAdvance paymentAdvance;

    public ReservationDayAdded(ReservationDayID reservationDayID, DateReserved date, PaymentAdvance paymentAdvance) {
        super("recordLabel.recordingSession.reservationDayadded");
        this.reservationDayID = reservationDayID;
        this.date = date;
        this.paymentAdvance = paymentAdvance;
    }

    public ReservationDayID getReservationDayID() {
        return reservationDayID;
    }

    public DateReserved getDate() {
        return date;
    }

    public PaymentAdvance getPaymentAdvance() {
        return paymentAdvance;
    }
}
