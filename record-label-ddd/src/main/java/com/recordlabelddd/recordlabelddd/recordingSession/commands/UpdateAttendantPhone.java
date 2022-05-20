package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.AttendantID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PhoneNumber;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;

public class UpdateAttendantPhone extends Command {
    private final RecordingSessionID recordingSessionID;
    private final AttendantID attendantID;
    private final PhoneNumber attendantPhone;

    public UpdateAttendantPhone(RecordingSessionID recordingSessionID, AttendantID attendantID, PhoneNumber attendantPhone) {
        this.recordingSessionID = recordingSessionID;
        this.attendantID = attendantID;
        this.attendantPhone = attendantPhone;
    }

    public RecordingSessionID getRecordingSessionID() {
        return recordingSessionID;
    }

    public AttendantID getAttendantID() {
        return attendantID;
    }

    public PhoneNumber getAttendantPhone() {
        return attendantPhone;
    }
}
