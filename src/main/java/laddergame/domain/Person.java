package laddergame.domain;

import laddergame.exception.CustomException;

import java.util.Objects;
import java.util.Optional;

public class Person {
    public static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;

    public Person(String name) {
        this.name = Optional.ofNullable(name)
                .map(String::trim)
                .filter((n) -> (0 < n.length() && n.length() <= MAX_LENGTH_OF_NAME))
                .orElseThrow(
                        () -> new CustomException("이름 양식에 맞지 않습니다. 빈 값 미허용, 최대 " + MAX_LENGTH_OF_NAME + "자")
                );
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
