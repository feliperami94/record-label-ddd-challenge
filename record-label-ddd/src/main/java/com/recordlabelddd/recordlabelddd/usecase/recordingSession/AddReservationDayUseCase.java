package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.recordlabelddd.recordlabelddd.recordingSession.RecordingSession;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddReservationDay;

public class AddReservationDayUseCase extends UseCase<RequestCommand<AddReservationDay>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddReservationDay> addReservationDayRequestCommand) {

        var command = addReservationDayRequestCommand.getCommand();
        var recordingSession = RecordingSession.from(
                command.getRecordingSessionID(),
                repository().getEventsBy(command.getRecordingSessionID().value()));

        recordingSession.addReservationDay(command.getReservationDayID(), command.getDateReserved(), command.getPaymentAdvance());

        emit().onResponse(new ResponseEvents(recordingSession.getUncommittedChanges()));

    }
}
