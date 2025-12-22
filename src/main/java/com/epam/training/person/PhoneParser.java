package com.epam.training.person;

import com.epam.training.person.domain.Phone;

public class PhoneParser {

    public static Phone parse(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }

        String cleaned = value.replaceAll("-", "").replaceAll("\\s+", "");
        if (cleaned.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number format: " + value);
        }

        String area = cleaned.substring(0, 3);
        String region = cleaned.substring(3, 6);
        String local = cleaned.substring(6, 10);

        return new Phone(area, region, local);
    }
}
