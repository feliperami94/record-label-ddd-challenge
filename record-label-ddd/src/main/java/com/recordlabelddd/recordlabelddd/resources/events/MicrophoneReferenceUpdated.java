package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MicType;
import com.recordlabelddd.recordlabelddd.resources.values.MicrophoneID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;

public class MicrophoneReferenceUpdated extends DomainEvent {
    private final MicrophoneID microphoneID;
    private final Reference micReference;

    public MicrophoneReferenceUpdated(MicrophoneID microphoneID, Reference micReference) {
        super("recordLabel.resources.MicrophoneReferenceUpdated");
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
