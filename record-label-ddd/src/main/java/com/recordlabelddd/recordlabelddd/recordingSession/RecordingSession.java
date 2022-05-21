package com.recordlabelddd.recordlabelddd.recordingSession;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.events.*;
import com.recordlabelddd.recordlabelddd.recordingSession.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class RecordingSession extends AggregateEvent<RecordingSessionID> {
    protected Confirmation confirmation;
    protected Set<Artist> artists;
    protected Set<ReservationDay> reservationDays;
    protected Set<Attendant> attendants;

    public RecordingSession(RecordingSessionID recordingSessionID, Confirmation confirmation) {
        super(recordingSessionID);
        appendChange(new RecordingSessionAdded(confirmation)).apply();
    }

    private RecordingSession(RecordingSessionID recordingSessionID){
        super(recordingSessionID);
        subscribe(new RecordingSessionChange(this));
    }

    public static RecordingSession from(RecordingSessionID recordingSessionID, List<DomainEvent> events){
        var recordingSession = new RecordingSession(recordingSessionID);
        events.forEach(recordingSession::applyEvent);
        return recordingSession;
    }

    public void updateConfirmation(Confirmation confirmation){
        Objects.requireNonNull(confirmation);
        appendChange(new ConfirmationUpdated(confirmation)).apply();
    }

    public void addArtist(ArtistID artistID, Name artistName, PhoneNumber artistPhone){
        Objects.requireNonNull(artistID);
        Objects.requireNonNull(artistName);
        Objects.requireNonNull(artistPhone);
        appendChange(new ArtistAdded(artistID, artistName, artistPhone)).apply();
    }

    public void updateArtistName(ArtistID artistID, Name artistName){
        Objects.requireNonNull(artistID);
        Objects.requireNonNull(artistName);
        appendChange(new ArtistNameUpdated(artistID, artistName)).apply();
    }

    public void updateArtistPhone(ArtistID artistID, PhoneNumber artistPhone){
        Objects.requireNonNull(artistID);
        Objects.requireNonNull(artistPhone);
        appendChange(new ArtistPhoneUpdated(artistID, artistPhone)).apply();
    }

    public void addReservationDay(ReservationDayID reservationDayID, DateReserved date, PaymentAdvance paymentAdvance){
        Objects.requireNonNull(reservationDayID);
        Objects.requireNonNull(date);
        Objects.requireNonNull(paymentAdvance);
        appendChange(new ReservationDayAdded(reservationDayID, date, paymentAdvance)).apply();
    }

    public void updateDate(ReservationDayID reservationDayID, DateReserved date){
        Objects.requireNonNull(reservationDayID);
        Objects.requireNonNull(date);
        appendChange(new DateUpdated(reservationDayID, date)).apply();
    }

    public void updatePaymentAdvance(ReservationDayID reservationDayID, PaymentAdvance paymentAdvance){
        Objects.requireNonNull(reservationDayID);
        Objects.requireNonNull(paymentAdvance);
        appendChange(new PaymentAdvanceUpdated(reservationDayID, paymentAdvance)).apply();
    }

    public void addAttendant(AttendantID attendantID, Name attendantName, PhoneNumber phoneNumber){
        Objects.requireNonNull(attendantID);
        Objects.requireNonNull(attendantName);
        Objects.requireNonNull(phoneNumber);
        appendChange(new AttendantAdded(attendantID, attendantName, phoneNumber)).apply();
    }

    public void updateAttendantName(AttendantID attendantID, Name attendantName){
        Objects.requireNonNull(attendantID);
        Objects.requireNonNull(attendantName);
        appendChange(new AttendantNameUpdated(attendantID, attendantName)).apply();
    }

    public void updateAttendantPhone(AttendantID attendantID, PhoneNumber attendantPhone){
        Objects.requireNonNull(attendantID);
        Objects.requireNonNull(attendantPhone);
        appendChange(new AttendantPhoneUpdated(attendantID, attendantPhone)).apply();
    }

    public void notifyReservation(String notification){
        Objects.requireNonNull(notification);
        appendChange(new ReservationNotified(notification)).apply();
    }



    protected Optional<Artist> getArtistByID(ArtistID artistID){
        return artists()
                .stream()
                .filter(artist -> artist.identity().equals(artistID))
                .findFirst();
    }

    protected Optional<ReservationDay> getReservationByID(ReservationDayID reservationDayID){
        return reservationDays()
                .stream()
                .filter(reservation -> reservation.identity().equals(reservationDayID))
                .findFirst();
    }

    protected Optional<Attendant> getAttendantByID(AttendantID attendantID){
        return attendants()
                .stream()
                .filter(attendant -> attendant.identity().equals(attendantID))
                .findFirst();
    }


    public Confirmation confirmation() {
        return confirmation;
    }

    public Set<Artist> artists() {
        return artists;
    }

    public Set<ReservationDay> reservationDays() {
        return reservationDays;
    }

    public Set<Attendant> attendants() {
        return attendants;
    }
}
