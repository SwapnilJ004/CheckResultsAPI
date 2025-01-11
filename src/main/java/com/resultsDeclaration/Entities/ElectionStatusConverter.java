package com.resultsDeclaration.Entities;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ElectionStatusConverter implements AttributeConverter<ElectionStatus, String> {
    @Override
    public String convertToDatabaseColumn(ElectionStatus status) {
        return status == null ? null : status.name();
    }

    @Override
    public ElectionStatus convertToEntityAttribute(String dbData) {
        return dbData == null ? null : ElectionStatus.valueOf(dbData);
    }
}

