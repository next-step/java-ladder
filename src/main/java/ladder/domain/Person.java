package ladder.domain;

import java.util.Objects;

public class Person {
    private String name;

    private Person(String name) {
        this.name = name;
    }

    public static Person getInstance(String name) {
        return new Person(name);
    }

    public static Person getNewInstance(Person person) {
        return new Person(person.name);
    }

    public static String nameOf(Person person) {
        return person.name;
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
