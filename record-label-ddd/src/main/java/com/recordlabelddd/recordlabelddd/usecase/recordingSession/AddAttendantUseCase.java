package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.recordlabelddd.recordlabelddd.recordingSession.RecordingSession;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddAttendant;

public class AddAttendantUseCase extends UseCase<RequestCommand<AddAttendant>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddAttendant> addAttendantRequestCommand) {

        var command = addAttendantRequestCommand.getCommand();
        var recordingSession = RecordingSession.from(
                command.getRecordingSessionID(),
                repository().getEventsBy(command.getRecordingSessionID().value()));

        recordingSession.addAttendant(command.getAttendantID(), command.getAttendantName(), command.getAttendantPhone());

        emit().onResponse(new ResponseEvents(recordingSession.getUncommittedChanges()));
    }
}
