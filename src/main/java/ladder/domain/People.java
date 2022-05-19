package ladder.domain;

import ladder.exception.InvalidCountOfPersonException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class People {

    public static final int MIN_COUNT_OF_PERSON = 2;
    private static final int EXCLUSION_POINT_VALUE = 1;

    private final List<Person> people;

    public People(String... people) {
        this(convertToPeople(people));
    }

    public People(List<Person> people) {
        if (people.size() < MIN_COUNT_OF_PERSON) {
            throw new InvalidCountOfPersonException();
        }
        this.people = people;
    }

    private static List<Person> convertToPeople(String... people) {
        return Stream.of(people)
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public int pointCount() {
        return people.size() - EXCLUSION_POINT_VALUE;
    }
}
