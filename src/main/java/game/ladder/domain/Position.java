package game.ladder.domain;

import spark.utils.Assert;

public class Position implements Comparable<Position> {

    public static final int MIN_VALUE = 1;

    private final int value;

    public Position(int value) {
        Assert.isTrue(isNotLowerThanMinValue(value), String.format("value의 크기는 %d 보다 작을 수 없습니다.", MIN_VALUE));
        this.value = value;
    }

    private boolean isNotLowerThanMinValue(int value) {
        return value >= MIN_VALUE;
    }

    public int nextValue() {
        return this.value + 1;
    }

    public int previousValue() {
        return this.value - 1;
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.value, other.value);
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

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }

    public int getValue() {
        return this.value;
    }
}
