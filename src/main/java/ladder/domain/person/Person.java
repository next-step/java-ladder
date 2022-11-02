package ladder.domain.person;

import ladder.domain.LadderTextInput;

import java.util.Objects;

public class Person {

    private final Position position;
    private final LadderTextInput name;

    public Person(String name, int x, int y) {
        this.name = new LadderTextInput(name);
        this.position = new Position(x, y);
    }

    public String name() {
        return this.name.text();
    }

    public Position position() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(position, person.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
