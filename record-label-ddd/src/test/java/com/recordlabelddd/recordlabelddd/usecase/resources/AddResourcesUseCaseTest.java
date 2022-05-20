package com.recordlabelddd.recordlabelddd.usecase.resources;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.resources.commands.AddResources;
import com.recordlabelddd.recordlabelddd.resources.events.ResourcesAdded;
import com.recordlabelddd.recordlabelddd.resources.values.GeneralAvailability;
import com.recordlabelddd.recordlabelddd.resources.values.ResourcesID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AddResourcesUseCaseTest {

    @Test
    void addResources(){
        var resourcesID = new ResourcesID();
        var generalAvailability = new GeneralAvailability(true);
        var command = new AddResources(resourcesID, generalAvailability);

        var useCase = new AddResourcesUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        ResourcesAdded event = (ResourcesAdded) events.get(0);
        Assertions.assertEquals(true, event.getGeneralAvailability().value());
    }

}