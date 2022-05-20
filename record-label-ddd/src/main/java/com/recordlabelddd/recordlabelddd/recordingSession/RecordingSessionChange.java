package com.recordlabelddd.recordlabelddd.recordingSession;

import co.com.sofka.domain.generic.EventChange;
import com.recordlabelddd.recordlabelddd.recordingSession.events.*;
import com.recordlabelddd.recordlabelddd.recordingSession.events.AttendantPhoneUpdated;

import java.util.HashSet;

public class RecordingSessionChange extends EventChange {

    public RecordingSessionChange(RecordingSession recordingSession){

        apply((RecordingSessionAdded event) -> {
            recordingSession.confirmation = event.getConfirmation();
            recordingSession.artists = new HashSet<>();
            recordingSession.reservationDays = new HashSet<>();
            recordingSession.attendants = new HashSet<>();
        });

        apply((ConfirmationUpdated event) -> {
            recordingSession.confirmation = event.getConfirmation();
        });

        apply((ArtistAdded event) -> {
            recordingSession.artists.add(new Artist(
                    event.getArtistID(),
                    event.getArtistName(),
                    event.getArtistPhone()
                    )
            );
        });

        apply((ArtistNameUpdated event) -> {
            var artist = recordingSession.getArtistByID(event.getArtistID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the artist"));
            artist.updateArtistName(event.getArtistName());
        });

        apply((ArtistPhoneUpdated event) -> {
            var artist = recordingSession.getArtistByID(event.getArtistID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the artist"));
            artist.updateArtistPhone(event.getArtistPhone());
        });

        apply((AttendantAdded event) -> {
            recordingSession.attendants.add(new Attendant(
                            event.getAttendantID(),
                            event.getAttendantName(),
                            event.getAttendantPhone()
                    )
            );
        });

        apply((AttendantNameUpdated event) -> {
            var attendant = recordingSession.getAttendantByID(event.getAttendantID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the attendant"));
            attendant.updateAttendantName(event.getAttendantName());
        });

        apply((AttendantPhoneUpdated event) -> {
            var attendant = recordingSession.getAttendantByID(event.getAttendantID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the attendant"));
            attendant.updateAttendantPhone(event.getAttendantPhone());
        });

        apply((ReservationDayAdded event) -> {
            recordingSession.reservationDays.add(new ReservationDay(
                            event.getReservationDayID(),
                            event.getDate(),
                            event.getPaymentAdvance()
                    )
            );
        });

        apply((DateUpdated event) -> {
            var reservationDay = recordingSession.getReservationByID(event.getReservationDayID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the reservation"));
            reservationDay.updateDate(event.getDate());
        });

        apply((PaymentAdvanceUpdated event) -> {
            var paymentAdvance = recordingSession.getReservationByID(event.getReservationDayID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the reservation"));
            paymentAdvance.updatePaymentAdvance(event.getPaymentAdvance());
        });


    }
}
