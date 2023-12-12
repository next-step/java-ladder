package nextstep.ladder.domain;

import java.util.Objects;

public class Position {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = Integer.MAX_VALUE;

    private final int current;

    public Position(int current) {
        validate(current);

        this.current = current;
    }

    private void validate(int current) {
        checkPositionLessThanMin(current);
        checkPositionMoreThanMax(current);
    }

    private void checkPositionLessThanMin(int current) {
        if (current < MIN_VALUE) {
            throw new IllegalArgumentException(
                    String.format("위치는 %d 이상이어야 합니다.", MIN_VALUE)
            );
        }
    }

    private void checkPositionMoreThanMax(int current) {
        if (current > MAX_VALUE) {
            throw new IllegalArgumentException(
                    String.format("위치는 %d 이하이어야 합니다.", MAX_VALUE)
            );
        }
    }

    public int current() {
        return current;
    }

    public Position left() {
        return new Position(current - 1);
    }

    public Position right() {
        return new Position(current + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return current == position.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(current);
    }
}
