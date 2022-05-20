package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.values.AttendantID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PhoneNumber;

public class AttendantAdded extends DomainEvent {
    private final AttendantID attendantID;
    private final Name attendantName;
    private final PhoneNumber attendantPhone;

    public AttendantAdded(AttendantID attendantID, Name attendantName, PhoneNumber attendantPhone) {
        super("recordLabel.recordingSession.attendantAdded");
        this.attendantID = attendantID;
        this.attendantName = attendantName;
        this.attendantPhone = attendantPhone;
    }

    public AttendantID getAttendantID() {
        return attendantID;
    }

    public Name getAttendantName() {
        return attendantName;
    }

    public PhoneNumber getAttendantPhone() {
        return attendantPhone;
    }
}
