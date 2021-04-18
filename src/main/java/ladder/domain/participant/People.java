package ladder.domain.participant;

import ladder.exception.ParticipantListNullPointerException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class People {

    private static final String ALL_COMMAND = "all";

    private final List<Person> people;

    public static final People of(String[] names) {
        return of(mapToPersonList(names));
    }

    private static final List<Person> mapToPersonList(String[] names) {
        return Arrays.stream(names)
                .map(Person::of)
                .collect(Collectors.toList());
    }

    public static final People of(List<Person> people) {
        return new People(people);
    }

    private People(List<Person> people) {
        validateNull(people);
        this.people = people;
    }

    private final void validateNull(List<Person> people) {
        if (Objects.isNull(people)) {
            throw new ParticipantListNullPointerException();
        }
    }

    public final Stream<Person> stream() {
        return people.stream();
    }

    public final Person person(int index) {
        return people.get(index);
    }

    public final List<String> values() {
        List<String> values = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        values.add(ALL_COMMAND);
        return values;
    }

    public final int countOfPerson() {
        return people.size();
    }

}
