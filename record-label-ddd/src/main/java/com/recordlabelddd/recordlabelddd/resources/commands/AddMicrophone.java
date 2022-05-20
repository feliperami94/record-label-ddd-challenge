package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MicType;
import com.recordlabelddd.recordlabelddd.resources.values.MicrophoneID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;

public class AddMicrophone extends Command {
    private final MicrophoneID microphoneID;
    private final Brand micBrand;
    private final Reference micReference;
    private final MicType micType;

    public AddMicrophone(MicrophoneID microphoneID, Brand micBrand, Reference micReference, MicType micType) {
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
