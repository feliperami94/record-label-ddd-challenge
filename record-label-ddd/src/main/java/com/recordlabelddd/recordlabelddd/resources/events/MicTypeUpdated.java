package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MicType;
import com.recordlabelddd.recordlabelddd.resources.values.MicrophoneID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;

public class MicTypeUpdated extends DomainEvent {
    private final MicrophoneID microphoneID;
    private final MicType micType;

    public MicTypeUpdated(MicrophoneID microphoneID, MicType micType) {
        super("recordLabel.resources.MicTypeUpdated");
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
