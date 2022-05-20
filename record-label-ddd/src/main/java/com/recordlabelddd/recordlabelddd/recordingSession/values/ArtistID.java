package com.recordlabelddd.recordlabelddd.recordingSession.values;

import co.com.sofka.domain.generic.Identity;

public class ArtistID extends Identity {
    public ArtistID(){

    }

    private ArtistID(String id){
        super(id);
    }

    public static ArtistID of(String id){
        return new ArtistID(id);
    }

}
