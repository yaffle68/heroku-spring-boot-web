package com.heroku.demo.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, String> {
    @Override
    public String convertToDatabaseColumn(LocalTime localTime) {
        return Optional.ofNullable(localTime)
            .map(LocalTime::toString)
            .orElse(null);
    }
    @Override
    public LocalTime convertToEntityAttribute(String timestamp) {
        return Optional.ofNullable(timestamp)
            .map(LocalTime::parse)
            .orElse(null);
    }
}
