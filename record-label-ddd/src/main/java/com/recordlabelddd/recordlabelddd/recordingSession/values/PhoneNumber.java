package com.recordlabelddd.recordlabelddd.recordingSession.values;

import co.com.sofka.domain.generic.ValueObject;

import java.text.ParseException;
import java.util.Objects;

public class PhoneNumber implements ValueObject<Integer> {
    private final Integer value;

    public PhoneNumber(Integer value) throws ParseException {
        this.value = Objects.requireNonNull(value);
        if(this.value < 10000000 || this.value > 99999999){
            throw new IllegalArgumentException("The phone number must have 8 digits");
        }

    }

    public Integer value(){
        return value;
    }


    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that =  (PhoneNumber) o;
        return Objects.equals(value, that.value);
    }
}
