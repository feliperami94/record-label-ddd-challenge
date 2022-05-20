package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MonitorsID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;
import com.recordlabelddd.recordlabelddd.resources.values.SubAvailable;

public class SubAvailableUpdated extends DomainEvent {
    private final MonitorsID monitorsID;
    private final SubAvailable subAvailable;

    public SubAvailableUpdated(MonitorsID monitorsID, SubAvailable subAvailable) {
        super("recordLabel.resources.SubAvailableUpdated");
        this.monitorsID = monitorsID;
        this.subAvailable = subAvailable;
    }

    public MonitorsID getMonitorsID() {
        return monitorsID;
    }

    public SubAvailable getSubAvailable() {
        return subAvailable;
    }
}
