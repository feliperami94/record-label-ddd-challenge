package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.recordlabelddd.recordlabelddd.resources.Resources;
import com.recordlabelddd.recordlabelddd.resources.commands.AddMicrophone;

public class AddMicrophoneUseCase extends UseCase<RequestCommand<AddMicrophone>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddMicrophone> addMicrophoneRequestCommand) {

        var command = addMicrophoneRequestCommand.getCommand();
        var resources = Resources.from(
                command.getResourcesID(),
                repository().getEventsBy(command.getResourcesID().value()));

        resources.addMicrophone(command.getMicrophoneID(), command.getMicBrand(), command.getMicReference(), command.getMicType());

        emit().onResponse(new ResponseEvents(resources.getUncommittedChanges()));

    }
}
