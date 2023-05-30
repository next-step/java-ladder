package nextstep.ladder;

import java.util.Objects;

public class Person {

    private final static int MAX_SIZE = 5;
    private final String name;

    public Person(String name) {
        if (name.length() > MAX_SIZE) {
            throw new IllegalArgumentException("사람의 이름은 최대 5글자");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualsName(String nameInput) {
        return name.equals(nameInput);
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
