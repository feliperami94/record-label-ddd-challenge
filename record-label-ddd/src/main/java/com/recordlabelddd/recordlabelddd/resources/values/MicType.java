package com.recordlabelddd.recordlabelddd.resources.values;

import co.com.sofka.domain.generic.ValueObject;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;

import java.text.ParseException;
import java.util.Objects;

public class MicType implements ValueObject<String> {
    private final String value;

    public MicType(String value) throws ParseException {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("The MicType can't be empty");
        }

        if(this.value != "Dynamic" && this.value != "Condenser" && this.value != "Ribbon"){
            throw new IllegalArgumentException("The mic type is not valid");
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
        MicType that =  (MicType) o;
        return Objects.equals(value, that.value);
    }
}
