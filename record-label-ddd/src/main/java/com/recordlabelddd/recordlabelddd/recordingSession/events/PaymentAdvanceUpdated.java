package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PaymentAdvance;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ReservationDayID;

public class PaymentAdvanceUpdated extends DomainEvent {
    private final ReservationDayID reservationDayID;
    private final PaymentAdvance paymentAdvance;

    public PaymentAdvanceUpdated(ReservationDayID reservationDayID, PaymentAdvance paymentAdvance) {
        super("recordLabel.recordingSession.paymentAdvanceUpdated");
        this.reservationDayID = reservationDayID;
        this.paymentAdvance = paymentAdvance;
    }

    public ReservationDayID getReservationDayID() {
        return reservationDayID;
    }

    public PaymentAdvance getPaymentAdvance() {
        return paymentAdvance;
    }
}
