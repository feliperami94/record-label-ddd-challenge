package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.recordlabelddd.recordlabelddd.recordingSession.RecordingSession;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddArtist;

public class AddArtistUseCase extends UseCase<RequestCommand<AddArtist>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddArtist> addArtistRequestCommand) {

        var command = addArtistRequestCommand.getCommand();
        var recordingSession = RecordingSession.from(
                command.getRecordingSessionID(),
                repository().getEventsBy(command.getRecordingSessionID().value()));

        recordingSession.addArtist(command.getArtistID(), command.getArtistName(), command.getArtistPhoneNumber());

        emit().onResponse(new ResponseEvents(recordingSession.getUncommittedChanges()));
    }
}
