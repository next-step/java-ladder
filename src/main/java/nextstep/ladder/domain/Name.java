package nextstep.ladder.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final String CREATE_NAME_ERROR = "사다리 게임에서 글자는 " + MAX_LENGTH + "자리 수 이하여야 합니다.";

    private final String value;

    public Name(final String value) {
        if (value.isEmpty() || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(CREATE_NAME_ERROR);
        }
        this.value = value;
    }

    public String getValue() {
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
}
