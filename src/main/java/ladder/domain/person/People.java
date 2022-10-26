package ladder.domain.person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people;

    public People(String[] strings) {
        this.people = Arrays.stream(strings)
                .map(Person::new)
                .collect(Collectors.toList());
    }
}
