package nextstep.ladder.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("invalid player name length");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Name{" +
                "value='" + value + '\'' +
                '}';
    }
}
