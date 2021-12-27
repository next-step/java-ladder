package ladderstep4.ladder.domain;

import java.util.Objects;

public class LadderStringValue implements LadderString {

    private static final String MAX_STRING_MESSAGE = "입력 값은 1~5자입니다.";
    private static final int MAX_VALUE = 5;

    private final String value;

    public LadderStringValue(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(MAX_STRING_MESSAGE);
        }
        String trimmedString = value.trim();

        if (trimmedString.isEmpty() || trimmedString.length() > MAX_VALUE) {
            throw new IllegalArgumentException(MAX_STRING_MESSAGE);
        }
        this.value = trimmedString;
    }

    @Override
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

        LadderStringValue that = (LadderStringValue) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
