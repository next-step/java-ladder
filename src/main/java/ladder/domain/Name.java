package ladder.domain;

import java.util.Objects;

public class Name {

    public static final int MAX_LENGTH = 5;
    private static final String NULL_OR_EMPTY_EXCEPTION_MESSAGE = "이름은 null 또는 빈 문자열일 수 없습니다";
    private static final String EXCEED_MAX_LENGTH_EXCEPTION_MESSaGE =
        "이름은 " + MAX_LENGTH + "글자를 초과할 수 없습니다";

    private final String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name from(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_EXCEPTION_MESSAGE);
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(EXCEED_MAX_LENGTH_EXCEPTION_MESSaGE);
        }
        return new Name(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Name{" +
            "value='" + value + '\'' +
            '}';
    }
}
