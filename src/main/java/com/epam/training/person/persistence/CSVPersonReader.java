package com.epam.training.person.persistence;

import com.epam.training.person.PhoneParser;
import com.epam.training.person.domain.Gender;
import com.epam.training.person.domain.Location;
import com.epam.training.person.domain.Person;
import com.epam.training.person.domain.Phone;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CSVPersonReader implements DataReader<List<Person>> {
    private final Scanner scanner;

    public CSVPersonReader(InputStream in){
        this.scanner = new Scanner(in);
    }

    @Override
    public List<Person> read() {
        List<Person> personList = new ArrayList<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");

                UUID id = UUID.fromString(parts[0]);
                String name = parts[1];
                LocalDate dateOfBirth = LocalDate.parse(parts[2]);
                Location placeOfBirth = new Location(parts[3],parts[4],parts[5],parts[6]);
                Gender gender = Gender.valueOf(parts[7].toUpperCase());

                List<Phone> phones = new ArrayList<>();
                for (int i = 8; i < parts.length; i++) {
                    String p = parts[i].trim();
                    if (!p.equals("-") && !p.isEmpty()) {
                        phones.add(PhoneParser.parse(p));
                    }
                }

                personList.add(new Person(id,name,dateOfBirth,placeOfBirth,gender,phones));

        }
        return personList;
    }

    public void close(){
        scanner.close();
    }
}
