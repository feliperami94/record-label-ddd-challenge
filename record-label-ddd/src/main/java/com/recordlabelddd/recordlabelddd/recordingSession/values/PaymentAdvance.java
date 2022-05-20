package com.recordlabelddd.recordlabelddd.recordingSession.values;

import co.com.sofka.domain.generic.ValueObject;

import java.text.ParseException;
import java.util.Objects;

public class PaymentAdvance implements ValueObject<Integer> {
    private final Integer value;

    public PaymentAdvance(Integer value) throws ParseException {
        this.value = Objects.requireNonNull(value);
        if(this.value <= 100 ){
            throw new IllegalArgumentException("The payment advance must be greater than 100 dollars");
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
        PaymentAdvance that =  (PaymentAdvance) o;
        return Objects.equals(value, that.value);
    }
}
