package ladder.domain;

import ladder.exception.InvalidCountOfPersonException;
import ladder.util.SplitUtil;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class People {

    public static final int MIN_COUNT_OF_PERSON = 2;
    private static final int EXCLUSION_POINT_VALUE = 1;

    private final List<Person> people;

    public People(String names) {
        this(convertToPeople(SplitUtil.split(names)));
    }

    public People(String... names) {
        this(convertToPeople(names));
    }

    public People(List<Person> people) {
        if (people.size() < MIN_COUNT_OF_PERSON) {
            throw new InvalidCountOfPersonException();
        }
        this.people = people;
    }

    private static List<Person> convertToPeople(String... names) {
        return IntStream.range(Position.MIN_VALUE, names.length)
                .mapToObj(index -> new Person(names[index], names.length - 1, index))
                .collect(Collectors.toList());
    }

    public int pointCount() {
        return people.size() - EXCLUSION_POINT_VALUE;
    }

    public List<Person> toList() {
        return Collections.unmodifiableList(people);
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
