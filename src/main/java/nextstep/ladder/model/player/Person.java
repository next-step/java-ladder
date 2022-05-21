package nextstep.ladder.model.player;

import java.util.Objects;

public class Person {

    private final Name name;

    private Person(Name name) {
        this.name = name;
    }

    public static Person of(String name) {
        return new Person(Name.of(name));
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(this.name, person.name);
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }
}
