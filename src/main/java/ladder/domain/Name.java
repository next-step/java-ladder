package ladder.domain;

import ladder.exception.InvalidNameException;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Name {

    public static final int MAX_LENGTH = 5;
    private static final int NEXT_INDEX = 1;
    private static final int KOREAN_UNIT_SIZE = 2;
    private static final int ENGLISH_OR_NUMBER_UNIT_SIZE = 1;
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

    public int size() {
        int size = 0;
        for (int i = 0; i < value.length(); i++) {
            String unit = value.substring(i, i + NEXT_INDEX);
            size += unitSize(unit);
        }
        return size;
    }

    private int unitSize(String unit) {
        if (unit.getBytes(StandardCharsets.UTF_8).length > ENGLISH_OR_NUMBER_UNIT_SIZE) {
            return KOREAN_UNIT_SIZE;
        }
        return ENGLISH_OR_NUMBER_UNIT_SIZE;
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
}
