package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MonitorsID;

public class UpdateMonitorsBrand extends Command {
    private final MonitorsID monitorsID;
    private final Brand monitorsBrand;

    public UpdateMonitorsBrand(MonitorsID monitorsID, Brand monitorsBrand) {
        this.monitorsID = monitorsID;
        this.monitorsBrand = monitorsBrand;
    }

    public MonitorsID getMonitorsID() {
        return monitorsID;
    }

    public Brand getMonitorsBrand() {
        return monitorsBrand;
    }
}
