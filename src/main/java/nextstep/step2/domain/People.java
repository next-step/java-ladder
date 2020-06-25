package nextstep.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people;

    public People(String names) {
        this.people = create(names);
    }

    public List<Person> create(String names) {
        return Arrays.stream(names.split(","))
            .map(Person::of)
            .collect(Collectors.toList());
    }

    public int getSize() {
        return people.size();
    }

    public List<Person> getPeople() {
        return people;
    }
}
