package com.epam.training.person.persistence;

import com.epam.training.person.domain.PhoneBook;
import com.epam.training.person.domain.Subscriber;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class XMLSubscriberWriter implements DataWriter<List<Subscriber>> {
    private final OutputStreamWriter outputWriter;

    public XMLSubscriberWriter(OutputStream out){
        this.outputWriter = new OutputStreamWriter(out);
    }

    @Override
    public void write(List<Subscriber> value) {
        try {
            JAXBContext context = JAXBContext.newInstance(PhoneBook.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            PhoneBook phoneBook = new PhoneBook(value);
            marshaller.marshal(phoneBook,outputWriter);
        }catch (Exception e){
            throw new RuntimeException("Failed to write XML. Error: " + e.getMessage());
        }
    }

    public void close(){
        try {
            outputWriter.close();
        }catch (Exception e){
            throw new RuntimeException("Failed to close XAML writer. Error:" + e.getMessage() );
        }
    }
}
