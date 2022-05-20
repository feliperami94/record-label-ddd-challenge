package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.Address;
import com.recordlabelddd.recordlabelddd.resources.values.StudioID;
import com.recordlabelddd.recordlabelddd.resources.values.StudioName;

public class AddStudio extends Command {
    private final StudioID studioID;
    private final StudioName studioName;
    private final Address address;

    public AddStudio(StudioID studioID, StudioName studioName, Address address) {
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
