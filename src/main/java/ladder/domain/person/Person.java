package ladder.domain.person;

import java.util.Objects;
import ladder.domain.Position;

public class Person {

    private final Position position;
    private final PersonName name;

    public Person(String name, int x, int y) {
        this.name = new PersonName(name);
        this.position = new Position(x, y);
    }

    public PersonName name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(position, person.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
