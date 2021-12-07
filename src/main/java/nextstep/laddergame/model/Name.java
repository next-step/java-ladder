package nextstep.laddergame.model;

import java.util.Objects;

import nextstep.laddergame.exception.InvalidNameException;

public class Name {

    private static final int LENGTH_LIMIT = 5;
    private static final String ALL_NAME = "all";
    public static final Name ALL = new Name(ALL_NAME);

    private final String name;

    public Name(String name) {
        validateOrThrow(name.trim());
        this.name = name.trim();
    }

    private void validateOrThrow(String name) {
        if (name == null || name.length() > LENGTH_LIMIT) {
            throw new InvalidNameException("name must be longer than " + LENGTH_LIMIT);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
