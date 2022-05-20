package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.AttendantID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;

public class UpdateAttendantName extends Command {
    private final RecordingSessionID recordingSessionID;
    private final AttendantID attendantID;
    private final Name attendantName;

    public UpdateAttendantName(RecordingSessionID recordingSessionID, AttendantID attendantID, Name attendantName) {
        this.recordingSessionID = recordingSessionID;
        this.attendantID = attendantID;
        this.attendantName = attendantName;
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
}
