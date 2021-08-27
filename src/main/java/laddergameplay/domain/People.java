package laddergameplay.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people;

    public People(List<String> peopleString) {
        this.people = peopleString.stream()
                .map(Person::new)
                .collect(Collectors.toList());;
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public boolean isSameSizeAs(int size) {
        return people.size() == size;
    }

    public int subtractNumberFromSize(int number) {
        return people.size() - number;
    }
}
