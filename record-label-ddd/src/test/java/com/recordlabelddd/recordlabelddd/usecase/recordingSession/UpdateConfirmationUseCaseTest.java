package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddRecordingSession;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddReservationDay;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.UpdateConfirmation;
import com.recordlabelddd.recordlabelddd.recordingSession.events.ConfirmationUpdated;
import com.recordlabelddd.recordlabelddd.recordingSession.events.RecordingSessionAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.events.ReservationDayAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateConfirmationUseCaseTest {

    @InjectMocks
    private UpdateConfirmationUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateConfirmationHappyPass() throws ParseException {
        //arrange
        RecordingSessionID recordingSessionID = RecordingSessionID.of("xxxyyy");
        Confirmation confirmation = new Confirmation(false);

        var initialAggregate = new AddRecordingSession(recordingSessionID, confirmation);

        Confirmation confirmationUpdated = new Confirmation(true);

        var command = new UpdateConfirmation(recordingSessionID, confirmationUpdated);

        when(repository.getEventsBy("xxxyyy")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRecordingSessionID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ConfirmationUpdated)events.get(0);

        Assertions.assertEquals(true, event.getConfirmation().value());


    }

    private List<DomainEvent> history(){
        Confirmation confirmation = new Confirmation(false);

        var event = new RecordingSessionAdded(confirmation);
        event.setAggregateRootId("xxxyyy");

        return List.of(event);

    }


}