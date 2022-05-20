package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Confirmation;
import com.recordlabelddd.recordlabelddd.resources.values.GeneralAvailability;

public class ResourcesAdded extends DomainEvent {
    private final GeneralAvailability generalAvailability;

    public ResourcesAdded(GeneralAvailability generalAvailability) {
        super("recordLabel.resources.resourcesAdded");
        this.generalAvailability = generalAvailability;
    }

    public GeneralAvailability getGeneralAvailability() {
        return generalAvailability;
    }
}
