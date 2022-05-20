package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MicType;
import com.recordlabelddd.recordlabelddd.resources.values.MicrophoneID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;

public class MicrophoneBrandUpdated extends DomainEvent {
    private final MicrophoneID microphoneID;
    private final Brand micBrand;

    public MicrophoneBrandUpdated(MicrophoneID microphoneID, Brand micBrand) {
        super("recordLabel.resources.MicrophoneBrandUpdated");
        this.microphoneID = microphoneID;
        this.micBrand = micBrand;

    }

    public MicrophoneID getMicrophoneID() {
        return microphoneID;
    }

    public Brand getMicBrand() {
        return micBrand;
    }

}
