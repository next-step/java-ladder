package ladder.domain;

import java.util.Objects;
import java.util.Optional;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String value;

    private Name(String value) {
        this.value = Optional.ofNullable(value)
                .map(String::trim)
                .filter(this::isValidLength)
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isValidLength(String name) {
        return MIN_LENGTH <= name.length() && name.length() < MAX_LENGTH;
    }

    public static Name valueOf(String name) {
        return new Name(name);
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Name{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
