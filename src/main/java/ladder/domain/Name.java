package ladder.domain;

import java.util.Objects;
import java.util.Optional;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    private Name(String name) {
        this.name = Optional.ofNullable(name)
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
