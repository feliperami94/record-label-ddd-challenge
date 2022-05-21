package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.AttendantID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PhoneNumber;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;

public class AddAttendant extends Command {
    private final RecordingSessionID recordingSessionID;
    private final AttendantID attendantID;
    private final Name attendantName;
    private final PhoneNumber attendantPhone;

    public AddAttendant(RecordingSessionID recordingSessionID, AttendantID attendantID, Name attendantName, PhoneNumber attendantPhone) {
        this.recordingSessionID = recordingSessionID;
        this.attendantID = attendantID;
        this.attendantName = attendantName;
        this.attendantPhone = attendantPhone;
    }

    public RecordingSessionID getRecordingSessionID() {
        return recordingSessionID;
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
