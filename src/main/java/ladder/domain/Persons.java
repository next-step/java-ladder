package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Persons {
    private final List<Person> persons;

    private Persons(List<Person> persons) {
        this.persons = new ArrayList<>(persons);
    }

    public static Persons of(List<Person> persons) {
        return new Persons(persons);
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
