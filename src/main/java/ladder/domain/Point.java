package ladder.domain;

import java.util.Random;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(Point previous) {
        if (previous.direction.isRight()) {
            return new Point(previous.index + 1, Direction.of(true, false));
        }
        return new Point(previous.index + 1, Direction.of(false, generateDirection()));
    }

    public static Point firstOf() {
        return new Point(0, Direction.first(generateDirection()));
    }

    public Point lastOf() {
        return new Point(index + 1, direction.last());
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return index;
    }

    public Direction getDirection() {
        return direction;
    }

    public static boolean generateDirection() {
        return new Random().nextBoolean();
    }

}
