package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.recordlabelddd.recordlabelddd.resources.Resources;
import com.recordlabelddd.recordlabelddd.resources.commands.UpdateGeneralAvailability;

public class UpdateGeneralAvailabilityUseCase extends UseCase<RequestCommand<UpdateGeneralAvailability>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateGeneralAvailability> updateGeneralAvailabilityRequestCommand) {

        var command = updateGeneralAvailabilityRequestCommand.getCommand();
        var resources = Resources.from(
                command.getResourcesID(),
                repository().getEventsBy(command.getResourcesID().value()));

        resources.updateGeneralAvailability(command.getGeneralAvailability());

        emit().onResponse(new ResponseEvents(resources.getUncommittedChanges()));
    }
}
