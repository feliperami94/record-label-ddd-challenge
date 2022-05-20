package com.recordlabelddd.recordlabelddd.resources.values;

import co.com.sofka.domain.generic.ValueObject;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Name;

import java.text.ParseException;
import java.util.Objects;

public class SubAvailable implements ValueObject<Boolean> {
    private final Boolean value;

    public SubAvailable(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    public Boolean value() {
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
        SubAvailable that =  (SubAvailable) o;
        return Objects.equals(value, that.value);
    }
}
