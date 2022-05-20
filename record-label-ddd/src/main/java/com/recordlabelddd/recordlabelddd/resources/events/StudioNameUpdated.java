package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Address;
import com.recordlabelddd.recordlabelddd.resources.values.StudioID;
import com.recordlabelddd.recordlabelddd.resources.values.StudioName;

public class StudioNameUpdated extends DomainEvent {
    private final StudioID studioID;
    private final StudioName studioName;

    public StudioNameUpdated(StudioID studioID, StudioName studioName) {
        super("recordLabel.resources.studioNameUpdated");
        this.studioID = studioID;
        this.studioName = studioName;
    }

    public StudioID getStudioID() {
        return studioID;
    }

    public StudioName getStudioName() {
        return studioName;
    }

}
