package com.epam.training.person;

import com.epam.training.person.domain.Phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneParser {

    private static final Pattern DASH_FORMAT = Pattern.compile("^(\\d{3})-(\\d{3})-(\\d{4})$");
    private static final Pattern NORMAL_FORMAT = Pattern.compile("^(\\d{3})(\\d{3})(\\d{4})$");

    public static Phone parse(String value) throws IllegalArgumentException {
        if ( value == null || value.trim().isEmpty() ) {
            throw new IllegalArgumentException("Phone string cannot be null or empty");
        }

        Matcher dashMatcher = DASH_FORMAT.matcher(value);
        if (dashMatcher.matches()){
            return new Phone(dashMatcher.group(1),dashMatcher.group(2),dashMatcher.group(3));
        }
        Matcher normalMatcher = NORMAL_FORMAT.matcher(value);
        if (normalMatcher.matches()){
            return new Phone(normalMatcher.group(1),normalMatcher.group(2),normalMatcher.group(3));
        }
        throw new IllegalArgumentException("Invalid phone number format: " + value );
    }
}
