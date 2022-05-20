package com.recordlabelddd.recordlabelddd.resources.commands;

import co.com.sofka.domain.generic.Command;
import com.recordlabelddd.recordlabelddd.resources.values.MonitorsID;
import com.recordlabelddd.recordlabelddd.resources.values.SubAvailable;

public class UpdateSubAvailable extends Command {
    private final MonitorsID monitorsID;
    private final SubAvailable subAvailable;

    public UpdateSubAvailable(MonitorsID monitorsID, SubAvailable subAvailable) {
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
