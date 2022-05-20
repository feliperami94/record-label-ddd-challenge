package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.AttendantID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;

public class AddAttendant extends Command {
    private final RecordingSessionID recordingSessionID;
    private final AttendantID attendantID;

    public AddAttendant(RecordingSessionID recordingSessionID, AttendantID attendantID) {
        this.recordingSessionID = recordingSessionID;
        this.attendantID = attendantID;
    }

    public RecordingSessionID getRecordingSessionID() {
        return recordingSessionID;
    }

    public AttendantID getAttendantID() {
        return attendantID;
    }
}
