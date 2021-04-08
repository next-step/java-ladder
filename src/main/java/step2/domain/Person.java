package step2;

import java.util.Objects;

public class Person {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Person(String name) {
        validateMoreThenFiveWord(name);
        this.name = name;
    }

    private void validateMoreThenFiveWord(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("글자는 5글자를 초과할 수 없습니다");
        }
    }

    public String of() {
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
}
