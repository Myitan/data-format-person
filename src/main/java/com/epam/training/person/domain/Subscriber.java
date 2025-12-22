package com.epam.training.person.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subscriber")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subscriber {
    @XmlElement(name = "phone-number")
    private String phone;
    @XmlElement(name = "client-name")
    private String clientName;


    public Subscriber(){}
    public Subscriber(String phone,String clientName){
        this.phone = phone;
        this.clientName = clientName;
    }

    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}
    public String getClientName(){return clientName;}
    public void setClientName(String clientName){this.clientName = clientName;}

}
