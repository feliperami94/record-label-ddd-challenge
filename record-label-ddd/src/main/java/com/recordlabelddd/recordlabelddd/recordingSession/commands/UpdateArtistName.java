package com.recordlabelddd.recordlabelddd.recordingSession.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;

public class UpdateArtistName extends Command {
    private final RecordingSessionID recordingSessionID;
    private final ArtistID artistID;
    private final Name artistName;

    public UpdateArtistName(RecordingSessionID recordingSessionID, ArtistID artistID, Name artistName) {
        this.recordingSessionID = recordingSessionID;
        this.artistID = artistID;
        this.artistName = artistName;
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
}
