package com.recordlabelddd.recordlabelddd.recordingSession;

import co.com.sofka.domain.generic.Entity;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PhoneNumber;

import java.util.Objects;

public class Artist extends Entity<ArtistID> {

    private Name name;
    private PhoneNumber phoneNumber;

    public Artist(ArtistID artistID, Name name, PhoneNumber phoneNumber) {
        super(artistID);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void updateArtistName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateArtistPhone(PhoneNumber phone){
        this.phoneNumber = phone;
    }

    public Name name(){
        return name;
    }

    public PhoneNumber phoneNumber(){
        return phoneNumber;
    }
}
