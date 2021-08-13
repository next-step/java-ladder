package nextstep.ladder.domain;

public class Position {
    private int position;
    private final Direction direction;

    public Position(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Position of (int position, Direction direction) {
        return new Position(position, direction);
    }

    public int move () {
        if (direction == Direction.LEFT) {
            return position - 1;
        }
        if (direction == Direction.RIGHT) {
            return position + 1;
        }
        return position;
    }
}
