# Introduction

The goal of the exercise is to process CSV file that contains persons' contact and personal data (name, place of birth, phone numbers, etc). 
Perform some transformation on the red data and create a phonebook that is represented as an XML file.
To handle the XML file, please use the learnt technology (JAXB).


# Data Model

The top element of the domain model is `Person` class. Every line of the CSV file represents the data of a single person.

There are some complex information represented by custom classes like `Location` or `Phone`.

You can persist the phone number in a strict format but from CSV file you can read two formats. To parse from different formats you have to use `PhoneParser` class.

`Subscriber` representing one element of phonebook. The exercise is to transform a `Person` to a `Subscriber`.

See an example of test data from CSV:

```csv
2b1a8035-0aa3-4865-9f0f-5c3e46a11289,John Doe,1985-07-15,US,United States,12345,New York,Male,1234567890,555-555-5555,-
```

The expected output in xml:

```xml
<phonebook>
    <subscribers>
        <phone>123-456-7890</phone>
        <client-name>John Doe</client-name>
    </subscribers>
    <subscribers>
        <phone>555-555-5555</phone>
        <client-name>John Doe</client-name>
    </subscribers>
</phonebook>
```

> The example shows one person, one location and a list of phones along with them.

# Specification

The domain classes are in the package of `com.epam.training.person.domain`:

- `Person` (Record)
- `Location` (R) contains fields of `iso3166`, `country`, `zip`, `city` all of them are `String`
- `Phone` (R) contains fields of `area`, `region`, `local` all of them are `String`
- `Gender` (Enum) contains `MALE`, and `FEMALE` instances
- `Subscriber` (Class) contains fields of `phone` and `clientName`, both of them are `String`
- `Phonebook` (C) contains only list of `Subscribers`

TODO: add diagram

## Persistence

The interfaces and classes responsible for persisting data can be found in `com.epam.training.person.persistence`:

- `DataReader`
- `DataWriter`
- `CSVPersonReader`
- `XMLSuscriberWriter`

Note: `DataReader` and `DataWriter` are generic types!

![](https://raw.githubusercontent.com/epam-java-cre/exercise-specification-images/main/data-format-person/persistence.png)

## Application

In the root package (`com.epam.training.person`), you can find the following types 

- `Application`
- `Transformer`
- `PersonDateOfBirthPredicate`
- `PersonSubscriberTransformer`
- `PhoneParser`

![](https://raw.githubusercontent.com/epam-java-cre/exercise-specification-images/main/data-format-person/application.png)


## XML

In this exercise we use *JAXB* to persist objects to XML format. You need to prepare `Subscriber` and `Phonebook`
by using annotations of JAXB to handle objects and transform them to XML elements automatically.

> Annotations can be found in the package of `jakarta.xml.bind.annotation`.

## Steps of the Execution

As an execution, your application should take the following steps in the next order:

1. The application reads the `person.csv` file up to a list of persons (`List<Person>`)
2. Transform the result of reading to list of subscribers (`List<Subscriber>`)
3. The list of subscribers is persisted into XML file

## Steps of Implementation

1. You get the `Application` class
2. You need to implement all the enums, classes and records placed in the package of`com.epam.training.person.domain`
3. You need to create and implement all the interfaces and classes in the package of `com.epam.training.person.persistence`
4. You also need to create and implement the `PersonDateOfBirthPredicate` and the `PersonSubscriberTransformer` classes
5. You have to make sure that the `PhoneParser` can handle the two different formats of phone numbers

`PersonDateOfBirthPredicate` is a `Predicate<T>` in which the `test` method returns `true` if the person was born
earlier than the given date and `false` otherwise.

`PersonSubscriberTransformer` transforms list of persons to list of subscribers.

`PhoneParser` is responsible for parsing strings representing phone numbers. The two formats are `##########` or `###-###-####`.
In case of any other formats, the `parse` function raises `IllegalArgumentException`.

```java
class PhoneParse {
    public static Phone parse(String value) throws IllegalArgumentException {
        /// 
    }
}
```

This task is tested in 3 phases:
- the result of processing csv
- the result of transforming data (from list of Person to list of Subscriber)
- the content of `phonebook.xml`
