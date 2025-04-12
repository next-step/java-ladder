package nextstep.ladder.domain;

import java.util.Objects;

public class Name {
    public static final String NULL_OR_EMPTY_ERROR_MESSAGE = "이름은 null 이거나 빈 문자열일 수 없습니다";
    public static final String TOO_LENGTH_ERROR_MESSAGE = "이름은 1자 이상 5자 이하로 입력해야 합니다";

    private final String value;

    public Name(String value) {
        this.valid(value);
        this.value = value.trim();
    }

    private void valid(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR_MESSAGE);
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(TOO_LENGTH_ERROR_MESSAGE + " - " + name);
        }
    }

    @Override
    public String toString() {
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
