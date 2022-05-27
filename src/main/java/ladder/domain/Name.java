package ladder.domain;

import ladder.exception.InvalidNameException;

import java.util.Objects;

public class Name {

    public static final int MAX_LENGTH = 5;
    private static final String MESSAGE_NULL_OR_BLANK = "이름은 공란이거나 Null 일 수 없습니다.";

    private final String value;

    public Name(String value) {
        if (isNullOrBlank(value)) {
            throw new InvalidNameException(MESSAGE_NULL_OR_BLANK);
        }
        if (isLowerMaxLength(value)) {
            throw new InvalidNameException();
        }
        this.value = value;
    }

    private boolean isNullOrBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isLowerMaxLength(String value) {
        return value.length() > MAX_LENGTH;
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

    @Override
    public String toString() {
        return value;
    }

    public int withoutNameSize(int size) {
        return size - value.length();
    }
}
