package com.recordlabelddd.recordlabelddd.resources;

import co.com.sofka.domain.generic.Entity;
import com.recordlabelddd.recordlabelddd.resources.values.Address;
import com.recordlabelddd.recordlabelddd.resources.values.StudioID;
import com.recordlabelddd.recordlabelddd.resources.values.StudioName;

import java.util.Objects;

public class Studio extends Entity<StudioID> {
    private StudioName studioName;
    private Address address;

    public Studio(StudioID studioID, StudioName studioName, Address address) {
        super(studioID);
        this.studioName = studioName;
        this.address = address;
    }

    public void updateStudioName(StudioName studioName) {
        this.studioName = Objects.requireNonNull(studioName);
    }

    public  void updateAddress(Address address){
        this.address = Objects.requireNonNull(address);
    }

    public StudioName studioName() {
        return studioName;
    }

    public Address address() {
        return address;
    }
}
