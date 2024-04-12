package nextstep.ladder.domain;

import java.util.Objects;

public class Person {
    private final String name;
    private final int position;

    private static final int NAME_LENGTH_STANDARD = 5;

    public Person(String name) {
        this(name, 0);
    }

    public Person(String name, int position) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("참가자의 이름은 (%s)와 같이 공백이거나 null일 수 없습니다.", name));
        }
        if (name.length() > NAME_LENGTH_STANDARD) {
            throw new IllegalArgumentException(String.format("참가자(%s)의 이름 글자수는 NAME_LENGTH_STANDARD를 초과할 수 없습니다", name));
        }
        this.name = name;
        this.position = position;
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
