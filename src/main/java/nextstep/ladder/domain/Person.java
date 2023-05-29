package nextstep.ladder.domain;

import java.util.Objects;

public class Person {

    private static final int NAME_LENGTH_MAX = 5;

    private final String name;

    public Person(String name) {
        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("글자수는 최대 5글자까지 부여할 수 있습니다.");
        }
        this.name = name;
    }

    public String name() {
        return this.name;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
