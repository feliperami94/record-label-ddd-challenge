package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.DateReserved;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ReservationDayID;

public class UpdateDate extends Command {
    private final RecordingSessionID recordingSessionID;
    private final ReservationDayID reservationDayID;
    private final DateReserved date;

    public UpdateDate(RecordingSessionID recordingSessionID, ReservationDayID reservationDayID, DateReserved date) {
        this.recordingSessionID = recordingSessionID;
        this.reservationDayID = reservationDayID;
        this.date = date;
    }

    public RecordingSessionID getRecordingSessionID() {
        return recordingSessionID;
    }

    public ReservationDayID getReservationDayID() {
        return reservationDayID;
    }

    public DateReserved getDate() {
        return date;
    }
}
