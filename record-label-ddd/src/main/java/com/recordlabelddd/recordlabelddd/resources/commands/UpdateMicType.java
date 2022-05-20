package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.MicType;
import com.recordlabelddd.recordlabelddd.resources.values.MicrophoneID;

public class UpdateMicType extends Command {
    private final MicrophoneID microphoneID;
    private final MicType micType;

    public UpdateMicType(MicrophoneID microphoneID, MicType micType) {
        this.microphoneID = microphoneID;
        this.micType = micType;
    }

    public MicrophoneID getMicrophoneID() {
        return microphoneID;
    }

    public MicType getMicType() {
        return micType;
    }
}
