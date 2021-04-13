package ladder.domain;

import ladder.exception.ParticipantListNullPointerException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class People {

    public static final String REGEX = ",";

    private final List<Person> people;

    private People(List<Person> people) {
        validateNull(people);
        this.people = people;
    }

    private final void validateNull(List<Person> people) {
        if (Objects.isNull(people)) {
            throw new ParticipantListNullPointerException();
        }
    }

    public static final People of(List<Person> people) {
        return new People(people);
    }

    public static final People of(String names) {
        return of(stringToParticipantList(names));
    }

    private static final List<Person> stringToParticipantList(String names) {
        return Arrays.stream(names.split(REGEX))
                .map(String::trim)
                .map(Person::of)
                .collect(Collectors.toList());
    }

    public final int countOfPerson() {
        return people.size();
    }

    public final Stream<Person> stream() {
        return people.stream();
    }
}
