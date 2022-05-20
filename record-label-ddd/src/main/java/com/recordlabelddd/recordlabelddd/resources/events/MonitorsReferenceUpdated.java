package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MonitorsID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;
import com.recordlabelddd.recordlabelddd.resources.values.SubAvailable;

public class MonitorsReferenceUpdated extends DomainEvent {
    private final MonitorsID monitorsID;
    private final Reference monitorsReference;

    public MonitorsReferenceUpdated(MonitorsID monitorsID, Reference monitorsReference) {
        super("recordLabel.resources.MonitorsReferenceUpdated");
        this.monitorsID = monitorsID;
        this.monitorsReference = monitorsReference;
    }

    public MonitorsID getMonitorsID() {
        return monitorsID;
    }

    public Reference getMonitorsReference() {
        return monitorsReference;
    }

}
