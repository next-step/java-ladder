package ladderstep4.ladder.domain;

public class Height {
    public static final String INVALID_VALUE_MESSAGE = "높이는 1 이상입니다.";

    private static final int MIN_VALUE = 1;

    private final int value;

    public Height(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
        this.value = value;
    }

    public int value() {
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

        Height position = (Height) o;

        return value == position.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
