package nextstep.ladder;

import java.util.Objects;

public class Name {

    public static final int MAX_LENGTH_OF_NAME = 5;

    private final String value;

    public Name(String value) {
        validateValue(value);
        this.value = value;
    }

    private static void validateValue(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }

        if (value.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름의 최대 길이는 " + MAX_LENGTH_OF_NAME + "입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
