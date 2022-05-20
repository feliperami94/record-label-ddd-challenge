package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Confirmation;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;

public class UpdateConfirmation extends Command {
    private final RecordingSessionID recordingSessionID;
    private final Confirmation confirmation;

    public UpdateConfirmation(RecordingSessionID recordingSessionID, Confirmation confirmation) {
        this.recordingSessionID = recordingSessionID;
        this.confirmation = confirmation;
    }

    public RecordingSessionID getRecordingSessionID() {
        return recordingSessionID;
    }

    public Confirmation getConfirmation() {
        return confirmation;
    }
}
