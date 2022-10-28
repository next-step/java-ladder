package ladder.domain.person;

import ladder.exception.person.IllegalPersonNameException;
import ladder.exception.person.PersonNameLengthException;

import java.util.Objects;

public class Person {

    private final String name;
    private final int PERSON_NAME_LENGTH_MAX = 5;

    public Person(String name) {
        validationName(name);
        this.name = name;
    }

    private void validationName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalPersonNameException();
        }
        if (name.length() > PERSON_NAME_LENGTH_MAX) {
            throw new PersonNameLengthException(PERSON_NAME_LENGTH_MAX);
        }
    }

    public String name() {
        return this.name;
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
        return Objects.hash(name, PERSON_NAME_LENGTH_MAX);
    }

    @Override
    public String toString() {
        return name;
    }
}
