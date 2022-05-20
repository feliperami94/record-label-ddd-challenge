package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;

public class ArtistNameUpdated  extends DomainEvent {
    private final ArtistID artistID;
    private final Name artistName;

    public ArtistNameUpdated(ArtistID artistID, Name artistName) {
        super("recordLabel.recordingSession.artistNameUpdated");
        this.artistID = artistID;
        this.artistName = artistName;
    }

    public ArtistID getArtistID() {
        return artistID;
    }

    public Name getArtistName() {
        return artistName;
    }
}
