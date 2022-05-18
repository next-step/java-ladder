package nextstep.ladder.model;

import java.util.Optional;

public class Person {

    private static final String OUT_OF_LENGTH_MESSAGE = "이름의 길이를 초과했습니다. 이름은 최대 5자까지 허용합니다.";

    private final String name;

    private Person(String name) {
        this.name = verify(name);
    }

    private static String verify(String name) {
        Optional.of(name)
                .map(String::length)
                .filter(length -> 0 < length)
                .filter(length -> length < 6)
                .orElseThrow(() -> new IndexOutOfBoundsException(OUT_OF_LENGTH_MESSAGE));

        return name;
    }

    public static Person is(String name) {
        return new Person(name);
    }

    public String name() {
        return this.name;
    }
}
