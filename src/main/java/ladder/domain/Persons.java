package ladder.domain;

import java.util.List;

public class Persons {
    private final List<Person> persons;

    public Persons(List<Person> persons) {
        this.persons = persons;
    }

    public int getSize() {
        return persons.size();
    }

    @Override
    public String toString() {
        return persons.stream()
                .map(person -> " " + person.toString())
                .reduce("", String::concat);
    }
}
