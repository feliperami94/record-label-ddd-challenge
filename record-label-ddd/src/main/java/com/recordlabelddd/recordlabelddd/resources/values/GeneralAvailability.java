package com.recordlabelddd.recordlabelddd.resources.values;

import co.com.sofka.domain.generic.ValueObject;
import com.recordlabelddd.recordlabelddd.recordingSession.values.Confirmation;

import java.util.Objects;

public class GeneralAvailability implements ValueObject<Boolean> {
    private final Boolean value;

    public GeneralAvailability(Boolean value) {
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
        GeneralAvailability that =  (GeneralAvailability) o;
        return Objects.equals(value, that.value);
    }
}
