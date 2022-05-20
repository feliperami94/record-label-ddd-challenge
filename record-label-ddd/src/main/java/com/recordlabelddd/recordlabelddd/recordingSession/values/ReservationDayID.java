package com.recordlabelddd.recordlabelddd.recordingSession.values;

import co.com.sofka.domain.generic.Identity;

public class ReservationDayID extends Identity {
    public ReservationDayID(){

    }

    private ReservationDayID(String id){
        super(id);
    }

    public static ReservationDayID of(String id){
        return new ReservationDayID(id);
    }
}
