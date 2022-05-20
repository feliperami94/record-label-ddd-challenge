package com.recordlabelddd.recordlabelddd.resources.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.values.Brand;
import com.recordlabelddd.recordlabelddd.resources.values.MonitorsID;
import com.recordlabelddd.recordlabelddd.resources.values.Reference;
import com.recordlabelddd.recordlabelddd.resources.values.SubAvailable;

public class MonitorsBrandUpdated extends DomainEvent {
    private final MonitorsID monitorsID;
    private final Brand monitorsBrand;


    public MonitorsBrandUpdated(MonitorsID monitorsID, Brand monitorsBrand) {
        super("recordLabel.resources.MonitorsBrandUpdated");
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
