package nextstep.ladder.domain.player;

import java.util.Objects;

public class Name {
    private static final int DEFAULT_NAME_LENGTH = 5;
    private static final String LENGTH_EXCEPTION_MESSAGE = "5글자 이하의 이름만 가능합니다.";
    private static final String NULL_BLANK_EXCEPTION_MESSAGE = "Null 또는 공백 문자열은 이름이 될 수 없습니다.";

    private final String value;

    public static Name of(String value) {
        return new Name(value);
    }

    public Name(String value) {
        validate(value);
        this.value = value.strip();
    }

    private void validate(String value) {
        if (isNullOrBlank(value)) {
            throw new IllegalArgumentException(NULL_BLANK_EXCEPTION_MESSAGE);
        }

        if (isOverLength(value)) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNullOrBlank(String value) {
        return Objects.isNull(value) || value.isBlank();
    }

    private boolean isOverLength(String value) {
        return value.strip().length() > DEFAULT_NAME_LENGTH;
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
        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
