package nextstep.ladder.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validValue(value);
        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }

    private void validValue(String value) {
        if (value == null || value.equals("") || value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("문자열의 값이 유효하지 않습니다.");
        }
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
}
