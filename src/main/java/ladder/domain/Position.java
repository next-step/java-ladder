package ladder.domain;

public class Position {
    public static final String INVALID_VALUE_MESSAGE = "음수 값을 가질 수 없습니다.";
    private static final int MIN_VALUE = 0;

    private final int value;

    public Position(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return value == position.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
