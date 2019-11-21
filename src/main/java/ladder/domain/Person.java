package ladder.domain;

import java.util.Objects;

public class Person {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Person(String name) {
        this.name = name;
        checkLength();
    }

    private void checkLength() {
        if (getLength() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("out of name range - 5글자이내로 입력하세요");
        }
    }

    public int getLength() {
        return name.length();
    }

    public String getName() {
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
