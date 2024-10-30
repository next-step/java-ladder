package nextstep.ladder.domain;

import java.util.Objects;

public class Person {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("공백을 넣을 수 없습니다");
        }

        if (isOverLength(name)) {
            throw new IllegalArgumentException("이름 최대 5자 넘을 수 없습니다");
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isOverLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    public int getLength() {
        return name.length();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
