package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Position {
    private static final int MIN_POSITION = 0;
    private static final int MOVE_POSITION = 1;

    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must be greater than or equal to 0");
        }
        this.value = value;
    }

    public Position moveBy(List<Boolean> points) {
        if (canMoveRight(points)) {
            return increase();
        }
        if (canMoveLeft(points)) {
            return decrease();
        }
        return new Position(this.value);
    }

    private boolean canMoveRight(List<Boolean> points) {
        return value < points.size() && points.get(value);
    }

    private boolean canMoveLeft(List<Boolean> points) {
        return value > MIN_POSITION && points.get(value - MOVE_POSITION);
    }

    private Position increase() {
        return new Position(this.value + MOVE_POSITION);
    }

    private Position decrease() {
        return new Position(this.value - MOVE_POSITION);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
