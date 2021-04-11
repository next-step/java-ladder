package ladder.domain;

import java.util.Objects;

public class Person {
    private final Name name;

    private Person(final Name name) {
        this.name = name;
    }

    public static Person from(final String name) {
        return new Person(Name.from(name));
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
        return String.valueOf(name);
    }
}
