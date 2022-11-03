package ladder.domain.person.name;

import ladder.exception.person.IllegalPersonNameException;

import java.util.Objects;

public class PersonName {

    public static final int INPUT_LENGTH_MAX = 5;
    private static final String FIND_ALL = "all";
    private final String name;

    public PersonName(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
    }

    private void validateEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalPersonNameException();
        }
    }

    private void validateLength(String name) {
        if (name.length() > INPUT_LENGTH_MAX) {
            throw new IllegalPersonNameException();
        }
    }

    public String name() {
        return this.name;
    }

    public static PersonName findAll() {
        return new PersonName(FIND_ALL);
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
