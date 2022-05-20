package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.events.AttendantAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.values.AttendantID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PhoneNumber;

public class AttendantPhoneUpdated extends DomainEvent {
    private final AttendantID attendantID;
    private final PhoneNumber attendantPhone;

    public AttendantPhoneUpdated(AttendantID attendantID, PhoneNumber attendantPhone) {
        super("recordLabel.recordingSession.attendantPhoneUpdated");
        this.attendantID = attendantID;
        this.attendantPhone = attendantPhone;
    }

    public AttendantID getAttendantID() {
        return attendantID;
    }

    public PhoneNumber getAttendantPhone() {
        return attendantPhone;
    }
}
