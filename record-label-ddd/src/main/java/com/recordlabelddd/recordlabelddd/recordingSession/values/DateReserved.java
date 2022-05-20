package com.recordlabelddd.recordlabelddd.recordingSession.values;

import co.com.sofka.domain.generic.ValueObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class DateReserved implements ValueObject<String> {
    private final String value;

    public DateReserved(String value) throws ParseException {
        Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("The DateReserved can't be empty");
        }
        SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
        Date valueDate = sdformat.parse(value);
        Date now = localDateToDate(LocalDate.now());
        if(valueDate.compareTo(now) <= 0 ){
            throw new IllegalArgumentException("The date can't be previous or equal to the current date");
        }
        this.value = value;
    }

    public String value(){
        return value;
    }

    private static Date localDateToDate(LocalDate localDate){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        return date;
    }


    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateReserved that =  (DateReserved) o;
        return Objects.equals(value, that.value);
    }


}
