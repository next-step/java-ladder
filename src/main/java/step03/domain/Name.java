package step03.domain;

import exception.OutOfNameLengthException;
import exception.UsingProhibitedNameException;

import java.util.Objects;
import java.util.Optional;

public class Name {
    private static final int MIN = 1;
    private static final int MAX = 5;
    private final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    private static void validate(String name) {
        Optional.ofNullable(name)
                .filter(n -> n.length() >= MIN && n.length() <= MAX)
                .orElseThrow(OutOfNameLengthException::new);
    }

    public void validateProhibitName(String prohibitedName) {
        if (name.equals(prohibitedName)) {
            throw new UsingProhibitedNameException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name that = (Name) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + "";
    }

}
