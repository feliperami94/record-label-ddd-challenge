package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.DateReserved;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PaymentAdvance;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ReservationDayID;

public class AddReservationDay extends Command {
    private final RecordingSessionID recordingSessionID;
    private final ReservationDayID reservationDayID;
    private final DateReserved dateReserved;
    private final PaymentAdvance paymentAdvance;

    public AddReservationDay(RecordingSessionID recordingSessionID, ReservationDayID reservationDayID, DateReserved dateReserved, PaymentAdvance paymentAdvance) {
        this.recordingSessionID = recordingSessionID;
        this.reservationDayID = reservationDayID;
        this.dateReserved = dateReserved;
        this.paymentAdvance = paymentAdvance;
    }

    public RecordingSessionID getRecordingSessionID() {
        return recordingSessionID;
    }

    public ReservationDayID getReservationDayID() {
        return reservationDayID;
    }

    public DateReserved getDateReserved() {
        return dateReserved;
    }

    public PaymentAdvance getPaymentAdvance() {
        return paymentAdvance;
    }
}
