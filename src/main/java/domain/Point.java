package domain;

import static domain.Direction.*;

public class Point {
    private final int position;
    private final Direction direction;

    private Point(final int position, final Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point of(final int position, final Direction direction) {
        return new Point(position, direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public int next() {
        if(direction == RIGHT) {
            return position + 1;
        }

        if(direction == LEFT) {
            return position - 1;
        }

        return position;
    }
}
