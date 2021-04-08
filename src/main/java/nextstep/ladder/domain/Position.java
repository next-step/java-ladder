package nextstep.ladder.domain;

import java.util.Objects;

public class Position {

    private static final String GUIDE_ERR_POSITION_BOUND = "왼쪽으로 이동할 수 없습니다.";
    public static final int MOVABLE_COUNT = 1;

    private final int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position valueOf(final int position) {
        return new Position(position);
    }

    public Position left() {
        if(isValidPositionBound()) {
            throw new IllegalArgumentException(GUIDE_ERR_POSITION_BOUND);
        }
        return new Position(value - MOVABLE_COUNT);
    }

    public Position right() {
        return new Position(value + MOVABLE_COUNT);
    }

    private boolean isValidPositionBound() {
        return value < 1;
    }

    public int currentPosition() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        final Position position1 = (Position) o;
        return value == position1.value;
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
