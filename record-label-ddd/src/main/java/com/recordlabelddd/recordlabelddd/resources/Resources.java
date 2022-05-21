package com.recordlabelddd.recordlabelddd.resources;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.recordlabelddd.recordlabelddd.recordingSession.*;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ArtistID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.AttendantID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.RecordingSessionID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.ReservationDayID;
import com.recordlabelddd.recordlabelddd.resources.events.*;
import com.recordlabelddd.recordlabelddd.resources.values.*;

import javax.management.monitor.Monitor;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Resources extends AggregateEvent<ResourcesID> {
    protected GeneralAvailability generalAvailability;
    protected Set<Studio> studios;
    protected Set<Microphone> microphones;
    protected Set<Monitors> monitors;

    public Resources(ResourcesID resourcesID, GeneralAvailability generalAvailability) {
        super(resourcesID);
        appendChange(new ResourcesAdded(generalAvailability)).apply();
    }

    private Resources(ResourcesID resourcesID){
        super(resourcesID);
        subscribe(new ResourcesChange(this));
    }

    public static Resources from(ResourcesID resourcesID, List<DomainEvent> events){
        var resources = new Resources(resourcesID);
        events.forEach(resources::applyEvent);
        return resources;
    }

    public void updateGeneralAvailability(GeneralAvailability generalAvailability){
        Objects.requireNonNull(generalAvailability);
        appendChange(new GeneralAvailabilityUpdated(generalAvailability)).apply();
    }


    public void addStudio( StudioID studioID, StudioName studioName, Address address){
        Objects.requireNonNull(studioID);
        Objects.requireNonNull(studioName);
        Objects.requireNonNull(address);
        appendChange(new StudioAdded(studioID, studioName, address)).apply();
    }

    public void updateStudioName(StudioID studioID, StudioName studioName){
        Objects.requireNonNull(studioID);
        Objects.requireNonNull(studioName);
        appendChange(new StudioNameUpdated(studioID, studioName)).apply();
    }

    public void updateAddress(StudioID studioID, Address address){
        Objects.requireNonNull(studioID);
        Objects.requireNonNull(address);
        appendChange(new AddressUpdated(studioID, address)).apply();
    }

    public void addMicrophone(MicrophoneID microphoneID, Brand micBrand, Reference micReference, MicType micType){
        Objects.requireNonNull(microphoneID);
        Objects.requireNonNull(micBrand);
        Objects.requireNonNull(micReference);
        Objects.requireNonNull(micType);
        appendChange(new MicrophoneAdded(microphoneID, micBrand, micReference, micType)).apply();
    }

    public void updateMicrophoneBrand(MicrophoneID microphoneID, Brand micBrand){
        Objects.requireNonNull(microphoneID);
        Objects.requireNonNull(micBrand);
        appendChange(new MicrophoneBrandUpdated(microphoneID, micBrand)).apply();
    }

    public void updateMicrophoneReference(MicrophoneID microphoneID,Reference micReference){
        Objects.requireNonNull(microphoneID);
        Objects.requireNonNull(micReference);
        appendChange(new MicrophoneReferenceUpdated(microphoneID, micReference)).apply();
    }

    public void updateMicType(MicrophoneID microphoneID, MicType micType){
        Objects.requireNonNull(microphoneID);
        Objects.requireNonNull(micType);
        appendChange(new MicTypeUpdated(microphoneID, micType)).apply();
    }

    public void addMonitors(MonitorsID monitorsID, Brand monitorsBrand, Reference monitorsReference, SubAvailable subAvailable){
        Objects.requireNonNull(monitorsID);
        Objects.requireNonNull(monitorsBrand);
        Objects.requireNonNull(monitorsReference);
        Objects.requireNonNull(subAvailable);
        appendChange(new MonitorsAdded(monitorsID, monitorsBrand, monitorsReference, subAvailable)).apply();
    }

    public void updateMonitorsBrand(MonitorsID monitorsID, Brand monitorsBrand){
        Objects.requireNonNull(monitorsID);
        Objects.requireNonNull(monitorsBrand);
        appendChange(new MonitorsBrandUpdated(monitorsID, monitorsBrand)).apply();
    }

    public void updateMonitorsReference(MonitorsID monitorsID, Reference monitorsReference){
        Objects.requireNonNull(monitorsID);
        Objects.requireNonNull(monitorsReference);
        appendChange(new MonitorsReferenceUpdated(monitorsID, monitorsReference)).apply();
    }

    public void updateSubAvailable(MonitorsID monitorsID, SubAvailable subAvailable){
        Objects.requireNonNull(monitorsID);
        Objects.requireNonNull(subAvailable);
        appendChange(new SubAvailableUpdated(monitorsID, subAvailable)).apply();
    }

    public void notifyChangeInAvailability(String notificationMessage){
        Objects.requireNonNull(notificationMessage);
        appendChange(new AvailabilityChangeNotified(notificationMessage)).apply();
    }




    protected Optional<Studio> getStudioByID(StudioID studioID){
        return studios()
                .stream()
                .filter(studio -> studio.identity().equals(studioID))
                .findFirst();
    }

    protected Optional<Microphone> getMicrophoneByID(MicrophoneID microphoneID){
        return microphones()
                .stream()
                .filter(microphone -> microphone.identity().equals(microphoneID))
                .findFirst();
    }

    protected Optional<Monitors> getMonitorsByID(MonitorsID monitorsID){
        return monitors()
                .stream()
                .filter(monitor -> monitor.identity().equals(monitorsID))
                .findFirst();
    }

    public GeneralAvailability generalAvailability() {
        return generalAvailability;
    }

    public Set<Studio> studios() {
        return studios;
    }

    public Set<Microphone> microphones() {
        return microphones;
    }

    public Set<Monitors> monitors() {
        return monitors;
    }
}
