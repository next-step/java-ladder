package step4.view;

import java.util.Objects;

public abstract class InputStringValue {
    private static final int MAX_LENGTH = 5;
    private final String value;

    public InputStringValue(String value) {
        validateInput(value);
        this.value = value;
    }

    private static void validateInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값은 빈값일 수 없습니다.");
        }

        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("입력값은 %d자를 넘길 수 없습니다.", MAX_LENGTH));
        }

        if (input.equals(ResultView.ALL)) {
            throw new IllegalArgumentException(String.format("입력값은 %s일 수 없습니다.", ResultView.ALL));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputStringValue that = (InputStringValue) o;
        return Objects.equals(value, that.value);
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
