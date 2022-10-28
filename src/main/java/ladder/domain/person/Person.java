package ladder.domain.person;

import ladder.exception.person.IllegalPersonNameException;
import ladder.exception.InputLengthException;

import java.util.Objects;

import static ladder.util.LadderConst.*;

public class Person {

    private final String name;
    private final int number;

    public Person(String name, int number) {
        validationName(name);
        this.name = name;
        this.number = number;
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
        return this.name;
    }

    public int number() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return number == person.number && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, INPUT_LENGTH_MAX);
    }

    @Override
    public String toString() {
        return name;
    }
}
