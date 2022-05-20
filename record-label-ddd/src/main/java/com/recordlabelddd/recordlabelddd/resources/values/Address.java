package com.recordlabelddd.recordlabelddd.resources.values;

import co.com.sofka.domain.generic.ValueObject;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;

import java.text.ParseException;
import java.util.Objects;

public class Address implements ValueObject<String> {
    private final String value;

    public Address(String value) throws ParseException {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("The Address can't be empty");
        }

        if(this.value.length() < 10){
            throw new IllegalArgumentException("The Address should be longer");
        }

        if(this.value.length() > 50){
            throw new IllegalArgumentException("The Address should be shorter");
        }

    }

    public String value(){
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
        Address that =  (Address) o;
        return Objects.equals(value, that.value);
    }
}
