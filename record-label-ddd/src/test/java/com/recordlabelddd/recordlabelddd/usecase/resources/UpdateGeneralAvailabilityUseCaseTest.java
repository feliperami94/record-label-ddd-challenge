package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.commands.AddStudio;
import com.recordlabelddd.recordlabelddd.resources.commands.UpdateGeneralAvailability;
import com.recordlabelddd.recordlabelddd.resources.events.GeneralAvailabilityUpdated;
import com.recordlabelddd.recordlabelddd.resources.events.ResourcesAdded;
import com.recordlabelddd.recordlabelddd.resources.events.StudioAdded;
import com.recordlabelddd.recordlabelddd.resources.values.*;
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
class UpdateGeneralAvailabilityUseCaseTest {

    @InjectMocks
    private UpdateGeneralAvailabilityUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateGeneralAvailabilityHappyPass() throws ParseException {
        //arrange
        ResourcesID resourcesID = ResourcesID.of("xxxyyy");
        GeneralAvailability generalAvailability = new GeneralAvailability(false);

        var command = new UpdateGeneralAvailability(resourcesID, generalAvailability);

        when(repository.getEventsBy("xxxyyy")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getResourcesID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (GeneralAvailabilityUpdated)events.get(0);

        Assertions.assertEquals(false, event.getGeneralAvailability().value());


    }

    private List<DomainEvent> history(){
        GeneralAvailability generalAvailability = new GeneralAvailability(true);

        var event = new ResourcesAdded(generalAvailability);
        event.setAggregateRootId("xxxyyy");

        return List.of(event);

    }

}