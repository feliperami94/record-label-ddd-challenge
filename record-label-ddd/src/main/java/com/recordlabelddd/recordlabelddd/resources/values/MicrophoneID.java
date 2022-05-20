package com.recordlabelddd.recordlabelddd.resources.values;

import co.com.sofka.domain.generic.Identity;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;

public class MicrophoneID extends Identity {

    public MicrophoneID(){

    }

    private MicrophoneID(String id){
        super(id);
    }

    public static MicrophoneID of(String id){
        return new MicrophoneID(id);
    }
}
