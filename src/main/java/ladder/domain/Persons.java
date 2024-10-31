package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Persons {
    private static final int MIN_PERSON_NUMBERS = 2;
    private static final String MIN_PERSON_NUMBERS_ERROR_MESSAGE = "참여 인원은 " + MIN_PERSON_NUMBERS + "명이상이어야 합니다.";
    private static final String DELIMITER = ",";

    private final List<Person> persons;


    private Persons(List<Person> persons) {
        this.persons = persons;
    }

    public static Persons from(String input) {
        List<Person> personList = Arrays.stream(validatePersonCount(parse(input)))
                .map(Person::new)
                .collect(Collectors.toList());

        return new Persons(personList);
    }

    public static Persons from(String... input) {
        List<Person> personList = Arrays.stream(validatePersonCount(input))
                .map(Person::new)
                .collect(Collectors.toList());

        return new Persons(personList);
    }

    private static String[] parse(String input) {
        return validatePersonCount(input.split(DELIMITER));
    }

    private static String[] validatePersonCount(String[] personArr) {
        if (personArr.length < MIN_PERSON_NUMBERS) {
            throw new IllegalArgumentException(MIN_PERSON_NUMBERS_ERROR_MESSAGE);
        }
        return personArr;
    }

    public int getSize() {
        return persons.size();
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(this.persons);
    }

    public Optional<Person> isSamePerson(String name) {
        return persons.stream()
                .filter(person -> person.isSameName(name)).findFirst();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons1 = (Persons) o;
        return Objects.equals(persons, persons1.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons);
    }

}
