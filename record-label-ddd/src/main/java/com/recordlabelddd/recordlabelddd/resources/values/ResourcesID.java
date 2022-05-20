package com.recordlabelddd.recordlabelddd.resources.values;

import co.com.sofka.domain.generic.Identity;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;

public class ResourcesID extends Identity {

    public ResourcesID(){

    }

    private ResourcesID(String id){
        super(id);
    }

    public static ResourcesID of(String id){
        return new ResourcesID(id);
    }
}
