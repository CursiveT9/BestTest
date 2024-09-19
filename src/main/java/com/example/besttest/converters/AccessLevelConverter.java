package com.example.besttest.converters;

import com.example.besttest.enums.AccessLevel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AccessLevelConverter implements AttributeConverter<AccessLevel, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AccessLevel attribute) {
//        System.out.println(attribute.getAccessLevelTypeCode());
        return attribute == null ? null : attribute.getAccessLevelTypeCode();
    }

    @Override
    public AccessLevel convertToEntityAttribute(Integer dbData) {
        for (AccessLevel accessLevel : AccessLevel.values()) {
            if (accessLevel.getAccessLevelTypeCode() == dbData) {
                return accessLevel;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);
    }
}
