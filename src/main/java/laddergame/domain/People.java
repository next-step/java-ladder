package laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people;

    public People(String peapleName) {
        this.people = Arrays.stream(peapleName.split(","))
                .map(String::trim)
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return people.size();
    }

    public List<Person> getPeople() {
        return people;
    }

}
