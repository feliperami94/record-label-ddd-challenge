package com.recordlabelddd.recordlabelddd.recordingSession.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Confirmation;

public class ConfirmationUpdated extends DomainEvent {
    private final Confirmation confirmation;

    public ConfirmationUpdated(Confirmation confirmation) {
        super("recordLabel.recordingSession.ConfirmationUpdated");
        this.confirmation = confirmation;
    }

    public Confirmation getConfirmation() {
        return confirmation;
    }
}
