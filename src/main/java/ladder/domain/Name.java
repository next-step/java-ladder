package ladder.domain;

import java.util.Objects;

public class Name {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";
    private final static String ERROR_OVER_FIVE_LETTERS = "5자 이하의 이름만 입력 가능합니다.";

    private final String value;

    public Name(final String name) {
        validate(name);
        this.value = name;
    }

    private void validate(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }

        if (input.length() > 5) {
            throw new IllegalArgumentException(ERROR_OVER_FIVE_LETTERS);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Name)) {
            return false;
        }

        return this.value.equals(((Name) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
