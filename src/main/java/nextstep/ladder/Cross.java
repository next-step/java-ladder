package nextstep.ladder;

import java.util.Objects;

public class Cross {

    private final Direction direction;
    private final boolean point;

    public Cross(boolean last, boolean current) {
        this.direction = direction(last, current);
        this.point = current;
    }

    private Direction direction(boolean last, boolean current) {
        if (current) {
            return Direction.RIGHT;
        }

        if (last) {
            return Direction.LEFT;
        }
        return Direction.SOUTH;
    }

    public int move(int verticalLine) {
        if (direction == Direction.RIGHT) {
            return verticalLine + 1;
        }
        if (direction == Direction.LEFT) {
            return verticalLine - 1;
        }
        return verticalLine;
    }

    public boolean getPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cross cross = (Cross) o;
        return point == cross.point && direction == cross.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, point);
    }
}
