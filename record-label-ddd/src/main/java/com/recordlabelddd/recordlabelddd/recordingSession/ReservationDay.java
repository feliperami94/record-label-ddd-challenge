package com.recordlabelddd.recordlabelddd.recordingSession;

import co.com.sofka.domain.generic.Entity;
import com.recordlabelddd.recordlabelddd.recordingSession.values.DateReserved;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PaymentAdvance;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ReservationDayID;

import java.util.Objects;

public class ReservationDay extends Entity<ReservationDayID> {

    public DateReserved date;
    public PaymentAdvance paymentAdvance;

    public ReservationDay(ReservationDayID reservationDayID, DateReserved date, PaymentAdvance paymentAdvance) {
        super(reservationDayID);
        this.date = date;
        this.paymentAdvance = paymentAdvance;
    }

    public void updateDate(DateReserved date){
        this.date = Objects.requireNonNull(date);
    }

    public void updatePaymentAdvance(PaymentAdvance paymentAdvance){
        this.paymentAdvance = Objects.requireNonNull(paymentAdvance);
    }

    public DateReserved date() {
        return date;
    }

    public PaymentAdvance paymentAdvance() {
        return paymentAdvance;
    }
}
