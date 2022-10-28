package ladder.domain.person;

import ladder.exception.person.PeopleSizeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people;
    private static final int PEOPLE_MIN = 2;

    public People(String... strings) {
        if (strings.length < PEOPLE_MIN) {
            throw new PeopleSizeException();
        }
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
