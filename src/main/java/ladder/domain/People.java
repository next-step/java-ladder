package ladder.domain;

import ladder.exception.ParticipantListNullPointerException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class People {

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

    public final int countOfPerson() {
        return people.size();
    }

    public final Stream<Person> stream() {
        return people.stream();
    }

    public Person get(Integer i) {
        return people.get(i);
    }

    public List<Integer> values() {
        return IntStream.range(0, countOfPerson())
                .boxed()
                .collect(Collectors.toList());
    }

}
