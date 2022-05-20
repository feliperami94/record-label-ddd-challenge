package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.*;

public class MicrophoneAdded extends DomainEvent {
    private final MicrophoneID microphoneID;
    private final Brand micBrand;
    private final Reference micReference;
    private final MicType micType;

    public MicrophoneAdded(MicrophoneID microphoneID, Brand micBrand, Reference micReference, MicType micType) {
        super("recordLabel.resources.MicrophoneAdded");
        this.microphoneID = microphoneID;
        this.micBrand = micBrand;
        this.micReference = micReference;
        this.micType = micType;
    }

    public MicrophoneID getMicrophoneID() {
        return microphoneID;
    }

    public Brand getMicBrand() {
        return micBrand;
    }

    public Reference getMicReference() {
        return micReference;
    }

    public MicType getMicType() {
        return micType;
    }
}
