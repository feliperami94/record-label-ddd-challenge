package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.events.RecordingSessionAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.events.ReservationNotified;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Confirmation;
import com.recordlabelddd.recordlabelddd.resources.events.AvailabilityChangeNotified;
import com.recordlabelddd.recordlabelddd.resources.events.ResourcesAdded;
import com.recordlabelddd.recordlabelddd.resources.values.GeneralAvailability;
import com.recordlabelddd.recordlabelddd.usecase.resources.NotifyChangeInAvailabilityUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotifyReservationUseCaseTest {

    private final String ROOTID = "9935332";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyReservationTest(){
        var event = new RecordingSessionAdded(
                new Confirmation(false)
        );
        event.setAggregateRootId(ROOTID);

        var useCase = new NotifyReservationUseCase();

        when(repository.getEventsBy(ROOTID)).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var message = (ReservationNotified)events.get(0);
        Assertions.assertEquals("The reservation has been created", message.getNotification());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}