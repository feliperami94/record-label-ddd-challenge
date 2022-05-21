package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddArtist;
import com.recordlabelddd.recordlabelddd.recordingSession.events.ArtistAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.events.RecordingSessionAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.values.*;
import com.recordlabelddd.recordlabelddd.resources.Resources;
import com.recordlabelddd.recordlabelddd.resources.commands.AddStudio;
import com.recordlabelddd.recordlabelddd.resources.events.ResourcesAdded;
import com.recordlabelddd.recordlabelddd.resources.events.StudioAdded;
import com.recordlabelddd.recordlabelddd.resources.values.*;
import com.recordlabelddd.recordlabelddd.usecase.recordingSession.AddArtistUseCase;
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
class AddStudioUseCaseTest {

    @InjectMocks
    private AddStudioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addStudioHappyPass() throws ParseException {
        //arrange
        ResourcesID resourcesID = ResourcesID.of("xxxyyy");
        StudioID studioID = StudioID.of("aaabbb");
        StudioName studioName = new StudioName("Example Studio 22");
        Address address = new Address("Cra 86 #30 - 25");

        var command = new AddStudio(resourcesID, studioID, studioName, address);

        when(repository.getEventsBy("xxxyyy")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getResourcesID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (StudioAdded)events.get(0);

        Assertions.assertEquals("Example Studio 22", event.getStudioName().value());
        Assertions.assertEquals("Cra 86 #30 - 25", event.getAddress().value());


    }

    private List<DomainEvent> history(){
        GeneralAvailability generalAvailability = new GeneralAvailability(true);

        var event = new ResourcesAdded(generalAvailability);
        event.setAggregateRootId("xxxyyy");

        return List.of(event);

    }

}