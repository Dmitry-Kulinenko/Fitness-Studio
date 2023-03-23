package by.itacademy.fitness.core.converter.json;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class LocalDateTimeToLong extends StdConverter<LocalDateTime, Long> {
    @Override
    public Long convert(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(OffsetDateTime.now().getOffset());
    }
}
