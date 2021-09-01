package newladder.model;

import newladder.util.RandomBoolean;

public class Direction {
    private static final int LEFT_VALUE = -1;
    private static final int RIGHT_VALUE = 1;
    private static final int STOP_VALUE = 0;
    private Point point;

    public Direction() {
        this.point = Point.first(RandomBoolean.random());
    }

    public Direction(Point point) {
        this.point = point;
    }

    public int move() {
        if (point.isLeft()) {
            return LEFT_VALUE;
        }
        if (point.isRight()) {
            return RIGHT_VALUE;
        }
        return STOP_VALUE;
    }

    public Direction next() {
        return new Direction(this.point.nextPoint(RandomBoolean.random()));
    }

    public Direction last() {
        return new Direction(this.point.last());
    }

    public Boolean printPoint() {
        return this.point.isRight();
    }
}
