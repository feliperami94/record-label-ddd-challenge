package com.recordlabelddd.recordlabelddd.resources;

import co.com.sofka.domain.generic.Entity;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MicrophoneID;
import com.recordlabelddd.recordlabelddd.resources.values.MicType;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;

import java.util.Objects;

public class Microphone extends Entity<MicrophoneID> {
    private Brand micBrand;
    private Reference micReference;
    private MicType micType;

    public Microphone(MicrophoneID microphoneID, Brand micBrand, Reference micReference, MicType micType) {
        super(microphoneID);
        this.micBrand = micBrand;
        this.micReference = micReference;
        this.micType = micType;
    }

    public void updateMicrophoneBrand(Brand micBrand){
        this.micBrand = Objects.requireNonNull(micBrand);
    }

    public void updateMicrophoneReference(Reference micReference){
        this.micReference = Objects.requireNonNull(micReference);
    }

    public void updateMicType(MicType micType){
        this.micType = Objects.requireNonNull(micType);
    }

    public Brand micBrand() {
        return micBrand;
    }

    public Reference micReference() {
        return micReference;
    }

    public MicType micType() {
        return micType;
    }
}
