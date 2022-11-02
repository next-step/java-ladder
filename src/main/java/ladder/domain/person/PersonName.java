package ladder.domain.person;

import ladder.exception.person.IllegalPersonNameException;

import java.util.Objects;

public class PersonName {

    private final String name;
    public static final int INPUT_LENGTH_MAX = 5;

    public PersonName(String name) {
        validEmpty(name);
        validLength(name);
        this.name = name;
    }

    private void validEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalPersonNameException();
        }
    }

    private void validLength(String name) {
        if (name.length() > INPUT_LENGTH_MAX) {
            throw new IllegalPersonNameException();
        }
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonName that = (PersonName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
