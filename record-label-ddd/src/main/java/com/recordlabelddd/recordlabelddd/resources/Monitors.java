package com.recordlabelddd.recordlabelddd.resources;

import co.com.sofka.domain.generic.Entity;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MonitorsID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;
import com.recordlabelddd.recordlabelddd.resources.values.SubAvailable;

import java.util.Objects;

public class Monitors extends Entity<MonitorsID> {
    private Brand monitorsBrand;
    private Reference monitorsReference;
    private SubAvailable subAvailable;

    public Monitors(MonitorsID monitorID, Brand monitorsBrand, Reference monitorsReference, SubAvailable subAvailable) {
        super(monitorID);
        this.monitorsBrand = monitorsBrand;
        this.monitorsReference = monitorsReference;
        this.subAvailable = subAvailable;
    }

    public void updateMonitorsBrand(Brand monitorsBrand){
        this.monitorsBrand = Objects.requireNonNull(monitorsBrand);
    }

    public void updateMonitorsReference(Reference monitorsReference){
        this.monitorsReference = Objects.requireNonNull(monitorsReference);
    }

    public void updateSubAvailable(SubAvailable subAvailable){
        this.subAvailable = Objects.requireNonNull(subAvailable);
    }




    public Brand monitorBrand() {
        return monitorsBrand;
    }

    public Reference monitorReference() {
        return monitorsReference;
    }

    public SubAvailable subAvailable() {
        return subAvailable;
    }
}
