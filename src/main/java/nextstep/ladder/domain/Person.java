package nextstep.ladder.domain;

import java.util.Objects;

public class Person {
    private final String name;
    private static final int NAME_LENGTH_STANDARD = 5;

    public Person(String name) {
        if (name.length() > NAME_LENGTH_STANDARD) {
            throw new IllegalArgumentException(String.format("참가자(%s)의 이름 글자수는 NAME_LENGTH_STANDARD를 초과할 수 없습니다", name));
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Person person = (Person) object;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
