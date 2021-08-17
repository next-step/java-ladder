package nextstep.ladder.model;

import java.util.Objects;

public class CoordinateValue implements Comparable<CoordinateValue> {
    private final int value;

    public CoordinateValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("높이는 음수가 될 수 없습니다!");
        }

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateValue that = (CoordinateValue) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(CoordinateValue other) {
        return value - other.value;
    }
}
