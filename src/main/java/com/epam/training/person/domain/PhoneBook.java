package com.epam.training.person.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name = "phonebook")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneBook {
    @XmlElement(name = "subscriber")
    private List<Subscriber> subscribers;

    public PhoneBook(){}
    public PhoneBook(List<Subscriber> subscribers){
        this.subscribers = subscribers;
    }
}
