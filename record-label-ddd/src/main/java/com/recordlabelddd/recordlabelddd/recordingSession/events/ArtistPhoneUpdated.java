package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PhoneNumber;

public class ArtistPhoneUpdated extends DomainEvent {
    private final ArtistID artistID;
    private final PhoneNumber artistPhone;

    public ArtistPhoneUpdated(ArtistID artistID, PhoneNumber artistPhone) {
        super("recordLabel.recordingSession.artistPhoneUpdated");
        this.artistID = artistID;
        this.artistPhone = artistPhone;
    }

    public ArtistID getArtistID() {
        return artistID;
    }

    public PhoneNumber getArtistPhone() {
        return artistPhone;
    }
}
