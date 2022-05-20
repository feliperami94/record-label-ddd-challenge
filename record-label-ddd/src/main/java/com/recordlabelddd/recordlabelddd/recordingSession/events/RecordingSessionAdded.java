package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.Artist;
import com.recordlabelddd.recordlabelddd.recordingSession.Attendant;
import com.recordlabelddd.recordlabelddd.recordingSession.ReservationDay;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Confirmation;

public class RecordingSessionAdded extends DomainEvent {
    private final Confirmation confirmation;

    public RecordingSessionAdded(Confirmation confirmation) {
        super("recordLabel.recordingSession.recordingSessionAdded");
        this.confirmation = confirmation;
    }

    public Confirmation getConfirmation() {
        return confirmation;
    }


}
