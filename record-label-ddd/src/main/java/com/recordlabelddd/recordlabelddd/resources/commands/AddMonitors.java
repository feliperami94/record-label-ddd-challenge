package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MonitorsID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;
import com.recordlabelddd.recordlabelddd.resources.values.SubAvailable;

public class AddMonitors extends Command {
    private final MonitorsID monitorsID;
    private final Brand monitorsBrand;
    private final Reference monitorsReference;
    private final SubAvailable subAvailable;

    public AddMonitors(MonitorsID monitorsID, Brand monitorsBrand, Reference monitorsReference, SubAvailable subAvailable) {
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
