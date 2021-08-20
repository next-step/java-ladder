package laddergame.domain;

import laddergame.exception.CustomException;

import java.util.Objects;
import java.util.Optional;

public class Person {
    public static final int MAX_LENGTH_OF_NAME = 5;
    public static final String LENGTH_OF_NAME_EXCEPTION_MESSAGE = "참여자 이름 양식 오류. 최대 " + MAX_LENGTH_OF_NAME + "자";
    public static final String EMPTY_STRING_EXCEPTION_MESSAGE = "참여자 이름 양식 오류. 빈 값 미허용";

    private final String name;

    public Person(String name) {
        this.name = Optional.ofNullable(name)
                .map(String::trim)
                .map(Person::validateLengthOfName)
                .map(Person::validateEmptyString)
                .orElseThrow(
                        () -> new CustomException(EMPTY_STRING_EXCEPTION_MESSAGE)
                );
    }

    private static String validateLengthOfName(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new CustomException(LENGTH_OF_NAME_EXCEPTION_MESSAGE);
        }
        return name;
    }

    private static String validateEmptyString(String name) {
        if (name.length() == 0) {
            throw new CustomException(EMPTY_STRING_EXCEPTION_MESSAGE);
        }
        return name;
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
