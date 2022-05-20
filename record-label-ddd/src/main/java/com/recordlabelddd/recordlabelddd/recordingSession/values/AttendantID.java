package com.recordlabelddd.recordlabelddd.recordingSession.values;

import co.com.sofka.domain.generic.Identity;

public class AttendantID extends Identity {
    public AttendantID(){

    }

    private AttendantID(String id){
        super(id);
    }

    public static AttendantID of(String id){
        return new AttendantID(id);
    }

}
