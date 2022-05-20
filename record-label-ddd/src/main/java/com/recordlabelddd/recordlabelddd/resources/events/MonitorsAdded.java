package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MonitorsID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;
import com.recordlabelddd.recordlabelddd.resources.values.SubAvailable;

public class MonitorsAdded extends DomainEvent {
    private final MonitorsID monitorsID;
    private final Brand monitorsBrand;
    private final Reference monitorsReference;
    private final SubAvailable subAvailable;

    public MonitorsAdded(MonitorsID monitorsID, Brand monitorsBrand, Reference monitorsReference, SubAvailable subAvailable) {
        super("recordLabel.resources.MonitorsAdded");
        this.monitorsID = monitorsID;
        this.monitorsBrand = monitorsBrand;
        this.monitorsReference = monitorsReference;
        this.subAvailable = subAvailable;
    }

    public MonitorsID getMonitorsID() {
        return monitorsID;
    }

    public Brand getMonitorsBrand() {
        return monitorsBrand;
    }

    public Reference getMonitorsReference() {
        return monitorsReference;
    }

    public SubAvailable getSubAvailable() {
        return subAvailable;
    }
}
