package nextstep.ladder.domain;

import java.util.Objects;

public class Name {
    private static final int NAME_LIMIT = 5;
    private final String name;

    private Name(final String name) {
        this.name = name;
    }

    public static Name of(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("invalid name: cannot be null or empty");
        }

        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("invalid name: too long " + name.length());
        }

        return new Name(name);
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
        return name;
    }
}
