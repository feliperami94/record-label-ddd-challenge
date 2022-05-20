package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddRecordingSession;
import com.recordlabelddd.recordlabelddd.recordingSession.events.RecordingSessionAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Confirmation;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AddRecordingSessionUseCaseTest {

    @Test
    void addRecordingSession(){
        var recordingSessionID = new RecordingSessionID();
        var confirmation = new Confirmation(false);
        var command = new AddRecordingSession(recordingSessionID, confirmation);

        var useCase = new AddRecordingSessionUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        RecordingSessionAdded event = (RecordingSessionAdded) events.get(0);
        Assertions.assertEquals(false, event.getConfirmation().value());
    }

}