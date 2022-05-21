package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.commands.AddMicrophone;
import com.recordlabelddd.recordlabelddd.resources.events.MicrophoneAdded;
import com.recordlabelddd.recordlabelddd.resources.events.ResourcesAdded;
import com.recordlabelddd.recordlabelddd.resources.values.*;
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
class AddMicrophoneUseCaseTest {

    @InjectMocks
    private AddMicrophoneUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addMicrophoneHappyPass() throws ParseException {
        //arrange
        ResourcesID resourcesID = ResourcesID.of("xxxyyy");
        MicrophoneID microphoneID = MicrophoneID.of("aaabbb");
        Brand micBrand = new Brand("Neumann");
        Reference micReference = new Reference("U-87");
        MicType micType = new MicType("Condenser");

        var command = new AddMicrophone(resourcesID, microphoneID, micBrand, micReference, micType);

        when(repository.getEventsBy("xxxyyy")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getResourcesID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MicrophoneAdded)events.get(0);

        Assertions.assertEquals("Neumann", event.getMicBrand().value());
        Assertions.assertEquals("U-87", event.getMicReference().value());
        Assertions.assertEquals("Condenser", event.getMicType().value());

    }

    private List<DomainEvent> history(){
        GeneralAvailability generalAvailability = new GeneralAvailability(true);

        var event = new ResourcesAdded(generalAvailability);
        event.setAggregateRootId("xxxyyy");

        return List.of(event);

    }


}