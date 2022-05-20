package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.recordlabelddd.recordlabelddd.recordingSession.RecordingSession;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddRecordingSession;
import com.recordlabelddd.recordlabelddd.resources.Resources;
import com.recordlabelddd.recordlabelddd.resources.commands.AddResources;

public class AddResourcesUseCase extends UseCase<RequestCommand<AddResources>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddResources> addResourcesRequestCommand) {
        var command = addResourcesRequestCommand.getCommand();
        var resources = new Resources(command.getResourcesID(), command.getGeneralAvailability());


        emit().onResponse(new ResponseEvents(resources.getUncommittedChanges()
        ));
    }
}
