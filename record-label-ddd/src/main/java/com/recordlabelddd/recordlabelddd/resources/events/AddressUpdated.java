package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Address;
import com.recordlabelddd.recordlabelddd.resources.values.StudioID;
import com.recordlabelddd.recordlabelddd.resources.values.StudioName;

public class AddressUpdated extends DomainEvent {
    private final StudioID studioID;
    private final Address address;

    public AddressUpdated(StudioID studioID, Address address) {
        super("recordLabel.resources.AddressUpdated");
        this.studioID = studioID;
        this.address = address;
    }

    public StudioID getStudioID() {
        return studioID;
    }

    public Address getAddress() {
        return address;
    }
}
