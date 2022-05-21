package nextstep.ladder.model;

import nextstep.ladder.exception.NameLengthExceedException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Person {

    private static final int MINIMUM_NAME_LENGTH = 0;
    private static final int MAXIMUM_NAME_LENGTH = 6;
    private static final String OUT_OF_LENGTH_MESSAGE = "이름의 길이를 초과했습니다. 이름은 최대 5자까지 허용합니다.";

    private final Name name;

    private Person(String name) {
        this.name = verify(name);
    }

    private static Name verify(String name) {
        return Optional.ofNullable(name)
                .filter(n -> MINIMUM_NAME_LENGTH < n.length())
                .filter(n -> n.length() < MAXIMUM_NAME_LENGTH)
                .map(Name::of)
                .orElseThrow(() -> new NameLengthExceedException(OUT_OF_LENGTH_MESSAGE));
    }

    public static Person of(String name) {
        return new Person(name);
    }

    public static List<Person> of(List<String> names) {
        return names
                .stream()
                .map(Person::of)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.name.toString();
    }
}
