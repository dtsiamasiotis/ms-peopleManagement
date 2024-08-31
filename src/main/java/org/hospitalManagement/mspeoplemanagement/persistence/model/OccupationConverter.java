package org.hospitalManagement.mspeoplemanagement.persistence.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class OccupationConverter implements AttributeConverter<Occupation, String> {
    @Override
    public String convertToDatabaseColumn(Occupation occupation) {
        if (occupation == null) {
            return null;
        }
        return occupation.name();
    }

    @Override
    public Occupation convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }

        return Stream.of(Occupation.values())
                .filter(c -> c.name().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }
}
