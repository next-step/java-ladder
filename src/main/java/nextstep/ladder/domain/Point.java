package nextstep.ladder.domain;

import java.util.Random;

public class Point {
    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isPoint() {
        return this.point;
    }

    public static Point first() {
        return new Point(new Random().nextBoolean());
    }

    public Point last() {
        return new Point(emptyPoint());
    }

    public Point next() {
        if (point) {
            return new Point(emptyPoint());
        }

        return new Point(randomPoint());
    }

    private boolean randomPoint() {
        return new Random().nextBoolean();
    }

    private boolean emptyPoint() {
        return false;
    }

    @Override
    public String toString() {
        return "Point{" +
                "point=" + point +
                '}';
    }

    public Direction compareMove(Point leftPoint, boolean firstIndex, boolean lastIndex) {
        if(firstIndex && this.point) {
            return Direction.RIGHT;
        }

        if(firstIndex) {
            return Direction.DOWN;
        }

        if(lastIndex && leftPoint.isPoint()) {
            return Direction.LEFT;
        }

        if(lastIndex) {
            return Direction.DOWN;
        }

        if(isPoint()) {
            return Direction.RIGHT;
        }

        if(leftPoint.isPoint()) {
            return Direction.LEFT;
        }

        return Direction.DOWN;
    }
}
