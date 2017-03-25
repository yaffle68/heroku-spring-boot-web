package com.heroku.demo.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {
    @Override
    public String convertToDatabaseColumn(LocalDate localDateTime) {
        return Optional.ofNullable(localDateTime)
            .map(LocalDate::toString)
            .orElse(null);
    }
    @Override
    public LocalDate convertToEntityAttribute(String timestamp) {
        return Optional.ofNullable(timestamp)
            .map(LocalDate::parse)
            .orElse(null);
    }
}
