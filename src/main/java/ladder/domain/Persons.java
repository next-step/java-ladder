package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Persons {
    private final Set<Person> persons;

    private Persons(final Set<Person> persons) {
        this.persons = persons;
    }

    public static Persons from(String[] personNames) {
        Set<Person> persons = Arrays.stream(personNames)
                .map(name -> Person.from(name))
                .collect(Collectors.toSet());
        validate(personNames, persons);
        return new Persons(persons);
    }

    private static void validate(String[] personNames, Set<Person> persons) {
        if (personNames.length != persons.size()) {
            throw new RuntimeException("참여할 사람 이름은 중복으로 입력할 수 없습니다.");
        }
    }

    public Set<Person> getPersons() {
        return Collections.unmodifiableSet(persons);
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
