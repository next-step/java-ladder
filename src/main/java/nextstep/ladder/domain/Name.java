package nextstep.ladder.domain;

import nextstep.ladder.exception.ExceedNameLengthException;

import java.util.Objects;

public class Name {
    private static final int PERSON_MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateNameSize(name);
        this.name = name;
    }

    private void validateNameSize(String name) {
        if (name.length() > PERSON_MAX_LENGTH) {
            throw new ExceedNameLengthException(name);
        }
    }

    public String name() {
        return name;
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

    @Override
    public String toString() {
        return String.format("%5s ", name);
    }
}
