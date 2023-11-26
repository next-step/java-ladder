package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Position {
    public static final String NEGATIVE_POSITION_MSG = "현재 위치는 0미만이 될 수 없습니다.";
    private final int value;
    private Position(final int position) {
        negativePositionCheck(position);
        this.value = position;
    }

    private static void negativePositionCheck(final int position) {
        if (position < 0) {
            throw new IllegalArgumentException(NEGATIVE_POSITION_MSG);
        }
    }

    public static Position of(final int position) {
        return new Position(position);
    }

    public int get() {
        return this.value;
    }

    public Position move(final List<Boolean> points) {
        if (points.get(this.value)) {
            return new Position(this.value + 1);
        }

        if (points.get(this.value - 1)) {
            return new Position(this.value - 1);
        }

        return this;
    }

    public Position movePostPosition(final List<Boolean> points) {
        if (points.get(this.value)) {
            return new Position(this.value + 1);
        }

        return this;
    }

    public Position movePrePosition(final List<Boolean> points) {
        if (points.get(this.value - 1)) {
            return new Position(this.value - 1);
        }

        return this;
    }

    public boolean isFirstPosition() {
        return this.value == 0;
    }
    public boolean isLastPosition(List<Boolean> points) {
        return this.value == points.size();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}

