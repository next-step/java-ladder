package ladder.domain.person;

import ladder.domain.LadderTextInput;
import ladder.exception.person.IllegalPersonNameException;
import ladder.exception.InputLengthException;

import java.awt.*;
import java.util.Objects;

public class Person {

    public static final int INPUT_LENGTH_MAX = 5;
    private final LadderTextInput name;
    private final Point position;

    public Person(String name, int x, int y) {
        validationName(name);
        this.name = new LadderTextInput(name);
        this.position = new Point(x, y);
    }

    private void validationName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalPersonNameException();
        }
        if (name.length() > INPUT_LENGTH_MAX) {
            throw new InputLengthException(INPUT_LENGTH_MAX);
        }
    }

    public String name() {
        return this.name.text();
    }

    public int getHorizontalPosition() {
        return this.position.x;
    }

    public int getVerticalPosition() {
        return this.position.y;
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
