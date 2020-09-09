package ladder.domain.point;

import java.util.Objects;

public class Position {
    private static final int START_POSITION = 0;
    private static final int MOVE_SIZE = 1;

    private final int movement;

    private Position(int movement) {
        this.movement = movement;
    }

    public static Position of(int movement) {
        return new Position(movement);
    }

    public static Position init() {
        return new Position(START_POSITION);
    }

    public int location() {
        return movement;
    }

    public Position left() {
        return new Position(movement - MOVE_SIZE);
    }

    public Position right() {
        return new Position(movement + MOVE_SIZE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return movement == that.movement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movement);
    }
}
