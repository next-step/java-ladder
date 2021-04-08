package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Persons {
    private List<Person> persons;

    private Persons(final List<Person> persons) {
        this.persons = persons;
    }

    public static Persons from(String[] personNames) {
        List<Person> persons = Arrays.stream(personNames)
                .map(name -> Person.from(name))
                .collect(Collectors.toList());
        return new Persons(persons);
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
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
