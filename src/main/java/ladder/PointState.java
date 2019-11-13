package ladder;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class PointState {
    enum Direction {
        LEFT(-1),
        RIGHT(1),
        CENTER(0);

        private int value;

        Direction(int value) {
            this.value = value;
        }

        int move(int index) {
            return index + value;
        }
    }

    private final Boolean left;
    private final Boolean current;

    public PointState(Boolean left, Boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.current = current;
    }

    public Direction move() {
        if (current) {
            return Direction.RIGHT;
        }

        if (left) {
            return Direction.LEFT;
        }

        return Direction.CENTER;
    }

    public PointState next(Boolean current) {
        if (this.current && current) {
            return new PointState(TRUE, FALSE);
        }

        return new PointState(this.current, current);
    }

    public PointState last() {
        return new PointState(this.current, FALSE);
    }

    public static PointState first(Boolean current) {
        return new PointState(FALSE, current);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointState pointState = (PointState) o;
        return left == pointState.left &&
                current == pointState.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }

    @Override
    public String toString() {
        return "PointState{" +
                "left=" + left +
                ", current=" + current +
                '}';
    }
}
