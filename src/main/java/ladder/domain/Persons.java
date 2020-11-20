package ladder.domain;

import java.util.List;

public class Persons {
    private final List<Person> persons;

    public Persons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return persons.stream()
                .map(person -> " " + person.toString())
                .reduce("", String::concat);
    }
}
