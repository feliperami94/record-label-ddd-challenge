package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.RecordingSession;
import com.recordlabelddd.recordlabelddd.recordingSession.events.RecordingSessionAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;
import com.recordlabelddd.recordlabelddd.resources.Resources;
import com.recordlabelddd.recordlabelddd.resources.values.ResourcesID;

public class NotifyReservationUseCase extends UseCase<TriggeredEvent<RecordingSessionAdded>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<RecordingSessionAdded> recordingSessionAddedTriggeredEvent) {
        var event = recordingSessionAddedTriggeredEvent.getDomainEvent();
        var recordingSession = RecordingSession.from(RecordingSessionID.of(event.aggregateRootId()), this.retrieveEvents());
        recordingSession.notifyReservation("The reservation has been created");

        emit().onResponse(new ResponseEvents(recordingSession.getUncommittedChanges()));
    }
}
