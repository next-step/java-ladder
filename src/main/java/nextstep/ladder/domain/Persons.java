package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Persons {
    private final List<Person> persons;


    public Persons(String[] texts) {
        this(Arrays.stream(texts)
                .map(Person::new)
                .collect(Collectors.toList()));
    }

    public Persons(List<Person> persons) {
        this.persons = persons;

    }

    public int personCount() {
        return persons.size();
    }

    public List<Person> getPersons() {
        return persons;
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
