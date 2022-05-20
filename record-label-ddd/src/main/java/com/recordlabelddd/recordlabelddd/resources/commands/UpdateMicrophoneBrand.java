package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MicrophoneID;

public class UpdateMicrophoneBrand extends Command {
    private final MicrophoneID microphoneID;
    private final Brand micBrand;

    public UpdateMicrophoneBrand(MicrophoneID microphoneID, Brand micBrand) {
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
