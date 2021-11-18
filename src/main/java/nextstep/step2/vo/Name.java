package nextstep.step2.vo;

import java.util.Objects;

public class Name {
    private static final String NOT_NULL_OR_EMPTY_EXCEPTION_MESSAGE = "이름은 빈 값이거나 null 일 수 없습니다.";
    private static final String RANGE_EXCEPTION_MESSAGE = "이름은 1~5자 입니다.";

    private final String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name create(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(NOT_NULL_OR_EMPTY_EXCEPTION_MESSAGE);
        }

        if (value.length() < 1 || value.length() > 5) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }

        return new Name(value);
    }

    public String getValue() {
        return value;
    }

    public int length() {
        return value.length();
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
}
