package com.epam.training.person.domain;

public record Phone(String area, String region, String local) {
    @Override
    public String toString(){
        return area + "-" + region + "-" + local;
    }
}
