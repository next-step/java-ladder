package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people;

    public People(List<String> peopleString) {
        this.people = peopleString.stream()
                .map(Person::new)
                .collect(Collectors.toList());;
    }

    public int size() {
        return people.size();
    }

    public List<Person> getPeople() {
        return people;
    }

}
