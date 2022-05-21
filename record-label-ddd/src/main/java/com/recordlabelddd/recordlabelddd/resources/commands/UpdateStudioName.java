package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.ResourcesID;
import com.recordlabelddd.recordlabelddd.resources.values.StudioID;
import com.recordlabelddd.recordlabelddd.resources.values.StudioName;

public class UpdateStudioName extends Command {
    private final ResourcesID resourcesID;
    private final StudioID studioID;
    private final StudioName studioName;

    public UpdateStudioName(ResourcesID resourcesID,StudioID studioID, StudioName studioName) {
        this.resourcesID = resourcesID;
        this.studioID = studioID;
        this.studioName = studioName;
    }

    public StudioID getStudioID() {
        return studioID;
    }

    public StudioName getStudioName() {
        return studioName;
    }

    public ResourcesID getResourcesID() {
        return resourcesID;
    }
}
