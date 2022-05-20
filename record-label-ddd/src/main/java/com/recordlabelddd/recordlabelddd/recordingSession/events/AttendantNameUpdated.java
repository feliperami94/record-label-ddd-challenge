package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.values.AttendantID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;

public class AttendantNameUpdated extends DomainEvent {
    private final AttendantID attendantID;
    private final Name attendantName;

    public AttendantNameUpdated(AttendantID attendantID, Name attendantName) {
        super("recordLabel.recordingSession.attendantNameUpdated");
        this.attendantID = attendantID;
        this.attendantName = attendantName;
    }

    public AttendantID getAttendantID() {
        return attendantID;
    }

    public Name getAttendantName() {
        return attendantName;
    }
}
