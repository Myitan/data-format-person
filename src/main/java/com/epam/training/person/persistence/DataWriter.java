package com.epam.training.person.persistence;

public interface DataWriter<DATA_TYPE> extends AutoClosable, AutoCloseable {
    void write(DATA_TYPE value);
}
