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

    public int number() {
        return people.size();
    }

    public List<String> toStrings() {
        return people.stream()
                .map(Person::toString)
                .collect(Collectors.toList());
    }
}
