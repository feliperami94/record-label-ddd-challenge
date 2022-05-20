package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PaymentAdvance;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ReservationDayID;

public class UpdatePaymentAdvance extends Command {
    private final RecordingSessionID recordingSessionID;
    private final ReservationDayID reservationDayID;
    private final PaymentAdvance paymentAdvance;

    public UpdatePaymentAdvance(RecordingSessionID recordingSessionID, ReservationDayID reservationDayID, PaymentAdvance paymentAdvance) {
        this.recordingSessionID = recordingSessionID;
        this.reservationDayID = reservationDayID;
        this.paymentAdvance = paymentAdvance;
    }

    public RecordingSessionID getRecordingSessionID() {
        return recordingSessionID;
    }

    public ReservationDayID getReservationDayID() {
        return reservationDayID;
    }

    public PaymentAdvance getPaymentAdvance() {
        return paymentAdvance;
    }
}
