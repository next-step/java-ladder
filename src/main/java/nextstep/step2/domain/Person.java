package nextstep.step2.domain;

import nextstep.step2.exception.Error;

import java.util.Objects;

public class Person {

    private final String name;

    public static Person of(String name) {
        return new Person(name);
    }

    private Person(String name) {
        checkEmpty(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkEmpty(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException(Error.NOT_ALLOW_EMPTY_STRING);
        }
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
