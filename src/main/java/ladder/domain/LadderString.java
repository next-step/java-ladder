package ladder.domain;

import java.util.Objects;

public class LadderString {

    private static final String MAX_STRING_MESSAGE = "입력 값은 1~5자입니다.";
    private static final int MAX_VALUE = 5;

    private final String value;

    public LadderString(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(MAX_STRING_MESSAGE);
        }
        String trimmedString = value.trim();

        if (trimmedString.isEmpty() || trimmedString.length() > MAX_VALUE) {
            throw new IllegalArgumentException(MAX_STRING_MESSAGE);
        }
        this.value = trimmedString;
    }

    public String getValue() {
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

        LadderString that = (LadderString) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

}
