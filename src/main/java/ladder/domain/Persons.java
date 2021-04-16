package ladder.domain;

import ladder.util.CollectionsUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Persons {
    private final List<Person> persons;

    private Persons(final List<Person> persons) {
        this.persons = persons;
    }

    public static Persons from(final String[] personNames) {
        return Arrays.stream(personNames)
                .map(Person::from)
                .distinct()
                .collect(collectingAndThen(
                        toList(),
                        persons -> new Persons(
                                CollectionsUtils.checkSize(persons, personNames.length))));
    }

    public int getCountOfPerson() {
        return persons.size();
    }

    public Person getPerson(final int index) {
        return persons.get(index);
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
