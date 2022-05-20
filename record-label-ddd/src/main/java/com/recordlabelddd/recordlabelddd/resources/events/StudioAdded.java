package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Address;
import com.recordlabelddd.recordlabelddd.resources.values.StudioID;
import com.recordlabelddd.recordlabelddd.resources.values.StudioName;

public class StudioAdded extends DomainEvent {
    private final StudioID studioID;
    private final StudioName studioName;
    private final Address address;

    public StudioAdded(StudioID studioID, StudioName studioName, Address address) {
        super("recordLabel.resources.studioAdded");
        this.studioID = studioID;
        this.studioName = studioName;
        this.address = address;
    }

    public StudioID getStudioID() {
        return studioID;
    }

    public StudioName getStudioName() {
        return studioName;
    }

    public Address getAddress() {
        return address;
    }
}
