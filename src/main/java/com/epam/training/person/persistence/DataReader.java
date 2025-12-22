package com.epam.training.person.persistence;

public interface DataReader<DATATYPE> extends AutoClosable, AutoCloseable {
    DATATYPE read();
}