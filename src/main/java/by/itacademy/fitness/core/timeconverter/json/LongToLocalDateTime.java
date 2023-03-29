package by.itacademy.fitness.core.timeconverter.json;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class LongToLocalDateTime extends StdConverter<Long, LocalDateTime> {
    @Override
    public LocalDateTime convert(Long aLong) {
        return LocalDateTime.ofEpochSecond(aLong, 0, OffsetDateTime.now().getOffset());
    }
}
