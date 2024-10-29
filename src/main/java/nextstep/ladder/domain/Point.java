package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private static final int MIN_VALUE = 0;

    private final int value;

    public Point(int value) {
        validateValue(value);
        this.value = value;
    }

    private static void validateValue(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("value는 0 미만일 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public Point minus() {
        return new Point(value - 1);
    }

    public Point plus() {
        return new Point(value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return value == point.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
