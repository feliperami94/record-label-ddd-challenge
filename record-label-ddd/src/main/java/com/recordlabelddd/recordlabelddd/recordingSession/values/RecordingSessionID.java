package com.recordlabelddd.recordlabelddd.recordingSession.values;

import co.com.sofka.domain.generic.Identity;

public class RecordingSessionID extends Identity {
    public RecordingSessionID(){

    }

    private RecordingSessionID(String id){
        super(id);
    }

    public static RecordingSessionID of(String id){
        return new RecordingSessionID(id);
    }

}
