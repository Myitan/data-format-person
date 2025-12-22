package com.epam.training.person.domain;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "subscriber")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"phone", "clientName"})
public record Subscriber(
        String phone,
        String clientName
) {
    public Subscriber() {
        this(null, null);
    }
    @XmlElement(name = "client-name")
    public String getClientName() {
        return clientName;
    }
    @XmlElement(name = "phone-number")
    public String getPhone() {
        return phone;
    }
}