package nextstep.ladder;

public class Cross {

    private final Direction direction;
    private final boolean point;

    public Cross(boolean last, boolean current) {
        this.direction = direction(last, current);
        this.point = current;
    }

    private Direction direction(boolean last, boolean current) {
        if (current)
            return Direction.RIGHT;
        if (last)
            return Direction.LEFT;
        return Direction.SOUTH;
    }

    public int move(int verticalLine) {
        if (direction == Direction.RIGHT)
            return verticalLine + 1;
        if (direction == Direction.LEFT)
            return verticalLine - 1;
        return verticalLine;
    }

    public boolean getPoint() {
        return point;
    }
}
