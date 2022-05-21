package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.recordlabelddd.recordlabelddd.recordingSession.RecordingSession;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddReservationDay;
import com.recordlabelddd.recordlabelddd.resources.Resources;
import com.recordlabelddd.recordlabelddd.resources.commands.AddStudio;

public class AddStudioUseCase extends UseCase<RequestCommand<AddStudio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddStudio> addStudioRequestCommand) {

        var command = addStudioRequestCommand.getCommand();
        var resources = Resources.from(
                command.getResourcesID(),
                repository().getEventsBy(command.getResourcesID().value()));

        resources.addStudio(command.getStudioID(), command.getStudioName(), command.getAddress());

        emit().onResponse(new ResponseEvents(resources.getUncommittedChanges()));

    }
}
