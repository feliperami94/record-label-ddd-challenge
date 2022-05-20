package com.recordlabelddd.recordlabelddd.resources;

import co.com.sofka.domain.generic.EventChange;
import com.recordlabelddd.recordlabelddd.recordingSession.Artist;
import com.recordlabelddd.recordlabelddd.recordingSession.events.ArtistAdded;
import com.recordlabelddd.recordlabelddd.recordingSession.events.ArtistNameUpdated;
import com.recordlabelddd.recordlabelddd.recordingSession.events.RecordingSessionAdded;
import com.recordlabelddd.recordlabelddd.resources.commands.AddMonitors;
import com.recordlabelddd.recordlabelddd.resources.events.*;

import java.util.HashSet;

public class ResourcesChange extends EventChange {

    public ResourcesChange(Resources resources) {
        apply((ResourcesAdded event) -> {
            resources.generalAvailability = event.getGeneralAvailability();
            resources.studios = new HashSet<>();
            resources.microphones = new HashSet<>();
            resources.monitors = new HashSet<>();
        });

        apply((GeneralAvailabilityUpdated event) -> {
            resources.generalAvailability = event.getGeneralAvailability();
        });

        apply((StudioAdded event) -> {
            resources.studios.add(new Studio(
                            event.getStudioID(),
                            event.getStudioName(),
                            event.getAddress()
                    )
            );
        });

        apply((StudioNameUpdated event) -> {
            var studio = resources.getStudioByID(event.getStudioID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the studio"));
            studio.updateStudioName(event.getStudioName());
        });

        apply((AddressUpdated event) -> {
            var studio = resources.getStudioByID(event.getStudioID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the studio"));
            studio.updateAddress(event.getAddress());
        });

        apply((MicrophoneAdded event) -> {
            resources.microphones.add(new Microphone(
                            event.getMicrophoneID(),
                            event.getMicBrand(),
                            event.getMicReference(),
                            event.getMicType()
                    )
            );
        });

        apply((MicrophoneBrandUpdated event) -> {
            var microphone = resources.getMicrophoneByID(event.getMicrophoneID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the microphone"));
            microphone.updateMicrophoneBrand(event.getMicBrand());
        });

        apply((MicrophoneReferenceUpdated event) -> {
            var microphone = resources.getMicrophoneByID(event.getMicrophoneID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the microphone"));
            microphone.updateMicrophoneReference(event.getMicReference());
        });

        apply((MicTypeUpdated event) -> {
            var microphone = resources.getMicrophoneByID(event.getMicrophoneID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the microphone"));
            microphone.updateMicType(event.getMicType());
        });

        apply((MonitorsAdded event) -> {
            resources.monitors.add(new Monitors(
                            event.getMonitorsID(),
                            event.getMonitorsBrand(),
                            event.getMonitorsReference(),
                            event.getSubAvailable()
                    )
            );
        });

        apply((MonitorsBrandUpdated event) -> {
            var monitors = resources.getMonitorsByID(event.getMonitorsID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the monitors"));
            monitors.updateMonitorsBrand(event.getMonitorsBrand());
        });

        apply((MonitorsReferenceUpdated event) -> {
            var monitors = resources.getMonitorsByID(event.getMonitorsID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the monitors"));
            monitors.updateMonitorsReference(event.getMonitorsReference());
        });

        apply((SubAvailableUpdated event) -> {
            var monitors = resources.getMonitorsByID(event.getMonitorsID())
                    .orElseThrow(() -> new IllegalArgumentException("Can't find the monitors"));
            monitors.updateSubAvailable(event.getSubAvailable());
        });

    }
}
