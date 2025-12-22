package com.epam.training.person.domain;

import java.util.Objects;

public record Location(String iso3166, String country, String zip, String city) {
}
