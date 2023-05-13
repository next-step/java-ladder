package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people;

    public People(List<Person> people) {
        this.people = people;
    }

    public People(String[] people) {
        this(Arrays.stream(people).
                map(Person::new).
                collect(Collectors.toList()));
    }

    int size() {
        return people.size();
    }

    @Override
    public String toString() {
        return "People{" +
                "people=" + people +
                '}';
    }
}
