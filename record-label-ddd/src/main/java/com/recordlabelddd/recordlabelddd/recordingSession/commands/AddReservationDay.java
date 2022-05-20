package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ReservationDayID;

public class AddReservationDay extends Command {
    private final RecordingSessionID recordingSessionID;
    private final ReservationDayID reservationDayID;

    public AddReservationDay(RecordingSessionID recordingSessionID, ReservationDayID reservationDayID) {
        this.recordingSessionID = recordingSessionID;
        this.reservationDayID = reservationDayID;
    }

    public RecordingSessionID getRecordingSessionID() {
        return recordingSessionID;
    }

    public ReservationDayID getReservationDayID() {
        return reservationDayID;
    }
}
