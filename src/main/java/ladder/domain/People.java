package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {
    private final static String DELIMITER = ",";

    private final List<Person> people;

    public People(String input) {
        this.people = Arrays.stream(input.split(DELIMITER))
            .map(Person::new)
            .collect(Collectors.toList());
    }

    public int size() {
        return people.size();
    }

    public List<Person> values() {
        return people;
    }
}
