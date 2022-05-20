package com.recordlabelddd.recordlabelddd.recordingSession;

import co.com.sofka.domain.generic.Entity;
import com.recordlabelddd.recordlabelddd.recordingSession.values.AttendantID;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;
import com.recordlabelddd.recordlabelddd.recordingSession.values.PhoneNumber;

import java.util.Objects;

public class Attendant extends Entity<AttendantID> {

    private Name name;
    private PhoneNumber phoneNumber;

    public Attendant(AttendantID attendantID, Name name, PhoneNumber phoneNumber) {
        super(attendantID);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void updateAttendantName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateAttendantPhone(PhoneNumber phone){
        this.phoneNumber = phone;
    }

    public Name name() {
        return name;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

}
