package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.GeneralAvailability;

public class GeneralAvailabilityUpdated extends DomainEvent {
    private final GeneralAvailability generalAvailability;

    public GeneralAvailabilityUpdated(GeneralAvailability generalAvailability) {
        super("recordLabel.resources.generalAvailabilityUpdated");
        this.generalAvailability = generalAvailability;
    }

    public GeneralAvailability getGeneralAvailability() {
        return generalAvailability;
    }
}
