package nextstep.ladder.domain.person;

import nextstep.ladder.domain.Position;

import java.util.Objects;

public class Person {

    private final Position position;
    private final Name name;

    public Person(String name) {
        this(Position.first(), name);
    }

    public Person(Position position, String name) {
        this.position = position;
        this.name = new Name(name);
    }

    public static Person first(String name) {
        return new Person(name);
    }

    public Person next(String name) {
        return new Person(position.nextPosition(), name);
    }

    public Position position() {
        return position;
    }

    public boolean equalName(Name name) {
        return this.name.equals(name);
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
        return name + " ";
    }
}
