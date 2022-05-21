package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddArtist;
import com.recordlabelddd.recordlabelddd.recordingSession.events.ArtistAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.events.RecordingSessionAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddArtistUseCaseTest {

    @InjectMocks
    private AddArtistUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addArtistHappyPass() throws ParseException {
        //arrange
        RecordingSessionID recordingSessionID = RecordingSessionID.of("xxxyyy");
        ArtistID artistID = ArtistID.of("aaabbb");
        Name artistName = new Name("ExampleArtistName");
        PhoneNumber artistPhone = new PhoneNumber(23456781);

        var command = new AddArtist(recordingSessionID, artistID, artistName, artistPhone);

        when(repository.getEventsBy("xxxyyy")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRecordingSessionID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ArtistAdded)events.get(0);

        Assertions.assertEquals("ExampleArtistName", event.getArtistName().value());
        Assertions.assertEquals(23456781, event.getArtistPhone().value());


    }

    private List<DomainEvent> history(){
        Confirmation confirmation = new Confirmation(false);

        var event = new RecordingSessionAdded(confirmation);
        event.setAggregateRootId("xxxyyy");

        return List.of(event);

    }
}