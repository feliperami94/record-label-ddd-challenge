package com.recordlabelddd.recordlabelddd.resources.values;

import co.com.sofka.domain.generic.Identity;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;

public class StudioID extends Identity {

    public StudioID(){

    }

    private StudioID(String id){
        super(id);
    }

    public static StudioID of(String id){
        return new StudioID(id);
    }
}
