package com.recordlabelddd.recordlabelddd.resources.values;

import co.com.sofka.domain.generic.Identity;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;

public class MonitorsID extends Identity {
    public MonitorsID(){

    }

    private MonitorsID(String id){
        super(id);
    }

    public static MonitorsID of(String id){
        return new MonitorsID(id);
    }
}
