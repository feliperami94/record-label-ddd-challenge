package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.*;

public class AddMicrophone extends Command {
    private final ResourcesID resourcesID;
    private final MicrophoneID microphoneID;
    private final Brand micBrand;
    private final Reference micReference;
    private final MicType micType;

    public AddMicrophone(ResourcesID resourcesID, MicrophoneID microphoneID, Brand micBrand, Reference micReference, MicType micType) {
        this.resourcesID = resourcesID;
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

    public ResourcesID getResourcesID() {
        return resourcesID;
    }
}
