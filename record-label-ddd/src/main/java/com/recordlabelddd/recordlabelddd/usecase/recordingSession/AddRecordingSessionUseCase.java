package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.recordlabelddd.recordlabelddd.recordingSession.RecordingSession;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddRecordingSession;

public class AddRecordingSessionUseCase extends UseCase<RequestCommand<AddRecordingSession>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddRecordingSession> addRecordingSessionRequestCommand) {

        var command = addRecordingSessionRequestCommand.getCommand();
        var recordingSession = new RecordingSession(command.getRecordingSessionID(), command.getConfirmation());


        emit().onResponse(new ResponseEvents(recordingSession.getUncommittedChanges()
        ));
    }
}
