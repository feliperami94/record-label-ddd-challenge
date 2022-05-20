package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PhoneNumber;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;

public class AddArtist extends Command {
    private final RecordingSessionID recordingSessionID;
    private final ArtistID artistID;
    private final Name artistName;
    private final PhoneNumber artistPhoneNumber;

    public AddArtist(RecordingSessionID recordingSessionID, ArtistID artistID, final Name artistName, final PhoneNumber artistPhoneNumber) {
        this.recordingSessionID = recordingSessionID;
        this.artistID = artistID;
        this.artistName = artistName;
        this.artistPhoneNumber = artistPhoneNumber;
    }

    public RecordingSessionID getRecordingSessionID() {
        return recordingSessionID;
    }

    public ArtistID getArtistID() {
        return artistID;
    }

    public Name getArtistName() {
        return artistName;
    }

    public PhoneNumber getArtistPhoneNumber() {
        return artistPhoneNumber;
    }
}
