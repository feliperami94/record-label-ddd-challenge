package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.recordlabelddd.recordlabelddd.resources.Resources;
import com.recordlabelddd.recordlabelddd.resources.commands.AddMonitors;

public class AddMonitorsUseCase extends UseCase<RequestCommand<AddMonitors>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddMonitors> addMonitorsRequestCommand) {

        var command = addMonitorsRequestCommand.getCommand();
        var resources = Resources.from(
                command.getResourcesID(),
                repository().getEventsBy(command.getResourcesID().value()));

        resources.addMonitors(command.getMonitorsID(), command.getMonitorsBrand(), command.getMonitorsReference(), command.getSubAvailable());

        emit().onResponse(new ResponseEvents(resources.getUncommittedChanges()));
    }
}
