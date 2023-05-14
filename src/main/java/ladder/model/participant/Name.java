package ladder.model.participant;

import java.util.Objects;

public class Name implements Comparable<Name> {
    public static final String ALL = "all";
    public static final int MAX_LENGTH = 5;
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    public static boolean isAll(Name name) {
        return name.value.equalsIgnoreCase(ALL);
    }

    private void validate(String value) {
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException("name is null or empty: " + value);
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("the length of name must be <= " + MAX_LENGTH);
        }
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Name o) {
        return value.compareTo(o.value);
    }
}
