package ladder;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class State {
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

    public State(Boolean left, Boolean current) {
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

    public State next(Boolean current) {
        if (this.current && current) {
            return new State(TRUE, FALSE);
        }

        return new State(this.current, current);
    }

    public State last() {
        return new State(this.current, FALSE);
    }

    public static State first(Boolean current) {
        return new State(FALSE, current);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return left == state.left &&
                current == state.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }

    @Override
    public String toString() {
        return "State{" +
                "left=" + left +
                ", current=" + current +
                '}';
    }
}
