package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.MonitorsID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;

public class UpdateMonitorsReference extends Command {
    private final MonitorsID monitorsID;
    private final Reference monitorsReference;

    public UpdateMonitorsReference(MonitorsID monitorsID, Reference monitorsReference) {
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
