package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.commands.AddMicrophone;
import com.recordlabelddd.recordlabelddd.resources.commands.AddMonitors;
import com.recordlabelddd.recordlabelddd.resources.events.MicrophoneAdded;
import com.recordlabelddd.recordlabelddd.resources.events.MonitorsAdded;
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
class AddMonitorsUseCaseTest {

    @InjectMocks
    private AddMonitorsUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addMonitorsHappyPass() throws ParseException {
        //arrange
        ResourcesID resourcesID = ResourcesID.of("xxxyyy");
        MonitorsID monitorsID = MonitorsID.of("aaabbb");
        Brand monitorsBrand = new Brand("Genelec");
        Reference monitorsReference = new Reference("8030");
        SubAvailable subAvailable = new SubAvailable(true);

        var command = new AddMonitors(resourcesID, monitorsID, monitorsBrand, monitorsReference, subAvailable);

        when(repository.getEventsBy("xxxyyy")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getResourcesID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MonitorsAdded)events.get(0);

        Assertions.assertEquals("Genelec", event.getMonitorsBrand().value());
        Assertions.assertEquals("8030", event.getMonitorsReference().value());
        Assertions.assertEquals(true, event.getSubAvailable().value());

    }

    private List<DomainEvent> history(){
        GeneralAvailability generalAvailability = new GeneralAvailability(true);

        var event = new ResourcesAdded(generalAvailability);
        event.setAggregateRootId("xxxyyy");

        return List.of(event);

    }


}