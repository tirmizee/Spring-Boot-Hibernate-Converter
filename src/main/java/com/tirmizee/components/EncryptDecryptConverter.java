package com.tirmizee.components;

import com.tirmizee.utils.AESUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EncryptDecryptConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return AESUtils.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return AESUtils.decrypt(dbData);
    }

}
