package com.recordlabelddd.recordlabelddd.recordingSession.values;

import co.com.sofka.domain.generic.ValueObject;
import org.springframework.beans.factory.annotation.Value;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Name implements ValueObject<String> {
    private final String value;

    public Name(String value) throws ParseException {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("The Name can't be empty");
        }

        if(this.value.length() < 3){
            throw new IllegalArgumentException("The Name must have 3 or more characters");
        }

        if(this.value.length() > 50){
            throw new IllegalArgumentException("The Name must have 50 or less characters");
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
        Name that =  (Name) o;
        return Objects.equals(value, that.value);
    }


}
