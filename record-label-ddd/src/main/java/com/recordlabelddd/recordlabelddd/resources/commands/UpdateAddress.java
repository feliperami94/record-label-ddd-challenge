package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.Address;
import com.recordlabelddd.recordlabelddd.resources.values.StudioID;
import com.recordlabelddd.recordlabelddd.resources.values.StudioName;

public class UpdateAddress extends Command {
    private final StudioID studioID;
    private final Address address;

    public UpdateAddress(StudioID studioID, Address address) {
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
