package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.recordlabelddd.recordlabelddd.resources.Resources;
import com.recordlabelddd.recordlabelddd.resources.events.GeneralAvailabilityUpdated;
import com.recordlabelddd.recordlabelddd.resources.events.ResourcesAdded;
import com.recordlabelddd.recordlabelddd.resources.values.ResourcesID;

public class NotifyChangeInAvailabilityUseCase extends UseCase<TriggeredEvent<ResourcesAdded>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<ResourcesAdded> resourcesAddedTriggeredEvent) {
        var event = resourcesAddedTriggeredEvent.getDomainEvent();
        var resources = Resources.from(ResourcesID.of(event.aggregateRootId()), this.retrieveEvents());
        resources.notifyChangeInAvailability("The general availability of the resources has changed");

        emit().onResponse(new ResponseEvents(resources.getUncommittedChanges()));
    }
}
