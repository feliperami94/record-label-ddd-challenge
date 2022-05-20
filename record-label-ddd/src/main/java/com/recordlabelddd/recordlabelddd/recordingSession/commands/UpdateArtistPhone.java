package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PhoneNumber;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;

public class UpdateArtistPhone extends Command {
    private final RecordingSessionID recordingSessionID;
    private final ArtistID artistID;
    private final PhoneNumber artistPhone;

    public UpdateArtistPhone(RecordingSessionID recordingSessionID, ArtistID artistID, PhoneNumber artistPhone) {
        this.recordingSessionID = recordingSessionID;
        this.artistID = artistID;
        this.artistPhone = artistPhone;
    }

    public RecordingSessionID getRecordingSessionID() {
        return recordingSessionID;
    }

    public ArtistID getArtistID() {
        return artistID;
    }

    public PhoneNumber getArtistPhone() {
        return artistPhone;
    }
}
