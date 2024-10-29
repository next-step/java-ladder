package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Persons {
    private static final int MIN_PERSON_NUMBERS = 2;
    private static final String MIN_PERSON_NUMBERS_ERROR_MESSAGE = "참여 인원은 " + MIN_PERSON_NUMBERS + "명이상이어야 합니다.";
    private static final String DELIMITER = ",";

    private final List<Person> persons;

    public Persons(String input) {
        this(parse(input));
    }

    public Persons(String... input) {
        this(IntStream.range(0, input.length)
                .mapToObj(index -> new Person(input[index], index))
                .collect(Collectors.toList()));
    }

    public Persons(List<Person> persons) {
        this.persons = persons;
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
