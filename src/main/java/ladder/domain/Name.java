package ladder.domain;

import ladder.exception.NameBlankException;
import ladder.exception.NameExceedException;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final String ALL = "all";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new NameBlankException();
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new NameExceedException();
        }
    }

    public boolean isAll() {
        return this.name.equals(ALL);
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
