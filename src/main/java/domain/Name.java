package domain;

import java.util.Objects;

public class Name {
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public Name(String name) {
        checkLengthIsBelowLimit(name);
        this.name = name;
    }

    private void checkLengthIsBelowLimit(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("The length of name must be below five");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Name other = (Name) object;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
