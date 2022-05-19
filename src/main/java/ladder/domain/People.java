package ladder.domain;

import ladder.exception.InvalidCountOfPersonException;
import ladder.util.SplitUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class People {

    public static final int MIN_COUNT_OF_PERSON = 2;
    private static final int EXCLUSION_POINT_VALUE = 1;

    private final List<Person> people;

    public People(String value) {
        this(convertToPeople(SplitUtil.split(value)));
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people1 = (People) o;
        return Objects.equals(people, people1.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(people);
    }
}
