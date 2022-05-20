package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.GeneralAvailability;
import com.recordlabelddd.recordlabelddd.resources.values.ResourcesID;

public class UpdateGeneralAvailability extends Command {
    private final ResourcesID resourcesID;
    private final GeneralAvailability generalAvailability;

    public UpdateGeneralAvailability(ResourcesID resourcesID, GeneralAvailability generalAvailability) {
        this.resourcesID = resourcesID;
        this.generalAvailability = generalAvailability;
    }

    public ResourcesID getResourcesID() {
        return resourcesID;
    }

    public GeneralAvailability getGeneralAvailability() {
        return generalAvailability;
    }
}
