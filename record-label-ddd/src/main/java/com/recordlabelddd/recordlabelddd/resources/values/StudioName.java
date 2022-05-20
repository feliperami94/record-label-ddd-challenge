package com.recordlabelddd.recordlabelddd.resources.values;

import co.com.sofka.domain.generic.ValueObject;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;

import java.text.ParseException;
import java.util.Objects;

public class StudioName implements ValueObject<String> {
    private final String value;

    public StudioName(String value) throws ParseException {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("The studio name can't be empty");
        }

        if(this.value.length() < 5){
            throw new IllegalArgumentException("The studio name must have 5 or more characters");
        }

        if(this.value.length() > 20){
            throw new IllegalArgumentException("The Name must have 20 or less characters");
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
        StudioName that =  (StudioName) o;
        return Objects.equals(value, that.value);
    }
}
