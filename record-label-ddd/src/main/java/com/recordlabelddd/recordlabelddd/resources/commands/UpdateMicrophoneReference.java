package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.MicrophoneID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;

public class UpdateMicrophoneReference extends Command {
    private final MicrophoneID microphoneID;
    private final Reference micReference;

    public UpdateMicrophoneReference(MicrophoneID microphoneID, Reference micReference) {
        this.microphoneID = microphoneID;
        this.micReference = micReference;
    }

    public MicrophoneID getMicrophoneID() {
        return microphoneID;
    }

    public Reference getMicReference() {
        return micReference;
    }
}
