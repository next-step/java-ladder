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
}
