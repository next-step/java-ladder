package laddergame.domain.user;

import java.util.Objects;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
    }

    public String getName() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
