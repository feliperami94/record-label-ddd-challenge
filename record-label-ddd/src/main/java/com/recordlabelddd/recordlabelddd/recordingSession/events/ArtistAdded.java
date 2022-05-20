package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PhoneNumber;

public class ArtistAdded extends DomainEvent {
    private final ArtistID artistID;
    private final Name artistName;
    private final PhoneNumber artistPhone;

    public ArtistAdded(ArtistID artistID, Name artistName, PhoneNumber artistPhone) {
        super("recordLabel.recordingSession.artistAdded");
        this.artistID = artistID;
        this.artistName = artistName;
        this.artistPhone = artistPhone;
    }

    public ArtistID getArtistID() {
        return artistID;
    }

    public Name getArtistName() {
        return artistName;
    }

    public PhoneNumber getArtistPhone() {
        return artistPhone;
    }
}
