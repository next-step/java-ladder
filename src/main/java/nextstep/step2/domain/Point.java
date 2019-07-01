package nextstep.step2.domain;

import java.util.Random;

public class Point {
    private static final Random RANDOM = new Random();
    private final Boolean point;

    private Point(final boolean point) {
        this.point = point;
    }

    public Point() {
        this(RANDOM.nextBoolean());
    }

    public static Point create(final Point beforePoint) {
        if (beforePoint.isPoint()) {
            return new Point(false);
        }
        return new Point();
    }

    public boolean isPoint() {
        return point;
    }

    @Override
    public String toString() {
        return point.toString();
    }
}
