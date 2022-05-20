package com.recordlabelddd.recordlabelddd.recordingSession.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Confirmation implements ValueObject<Boolean> {
    private final Boolean value;

    public Confirmation(Boolean value) {
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
        Confirmation that =  (Confirmation) o;
        return Objects.equals(value, that.value);
    }
}
