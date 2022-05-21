package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.recordlabelddd.recordlabelddd.recordingSession.RecordingSession;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddReservationDay;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.UpdateConfirmation;

public class UpdateConfirmationUseCase extends UseCase<RequestCommand<UpdateConfirmation>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateConfirmation> updateConfirmationRequestCommand) {
            var command = updateConfirmationRequestCommand.getCommand();
            var recordingSession = RecordingSession.from(
                    command.getRecordingSessionID(),
                    repository().getEventsBy(command.getRecordingSessionID().value()));

            recordingSession.updateConfirmation(command.getConfirmation());

            emit().onResponse(new ResponseEvents(recordingSession.getUncommittedChanges()));
    }
}
