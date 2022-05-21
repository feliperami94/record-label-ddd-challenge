package com.recordlabelddd.recordlabelddd.usecase.recordingSession;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddAttendant;
import com.recordlabelddd.recordlabelddd.recordingSession.commands.AddReservationDay;
import com.recordlabelddd.recordlabelddd.recordingSession.events.AttendantAdded;
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

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AddReservationDayUseCaseTest {


    @InjectMocks
    private AddReservationDayUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addReservationDayHappyPass() throws ParseException {
        //arrange
        RecordingSessionID recordingSessionID = RecordingSessionID.of("xxxyyy");
        ReservationDayID reservationDayID = ReservationDayID.of("aaabbb");
        DateReserved dateReserved = new DateReserved("20-07-2022");
        PaymentAdvance paymentAdvance = new PaymentAdvance(100000);

        var command = new AddReservationDay(recordingSessionID, reservationDayID, dateReserved, paymentAdvance);

        when(repository.getEventsBy("xxxyyy")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRecordingSessionID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ReservationDayAdded)events.get(0);

        Assertions.assertEquals("20-07-2022", event.getDate().value());
        Assertions.assertEquals(100000, event.getPaymentAdvance().value());


    }

    private List<DomainEvent> history(){
        Confirmation confirmation = new Confirmation(false);

        var event = new RecordingSessionAdded(confirmation);
        event.setAggregateRootId("xxxyyy");

        return List.of(event);

    }
}
