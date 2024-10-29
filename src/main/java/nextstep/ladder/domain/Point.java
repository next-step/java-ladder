package nextstep.ladder.domain;

import java.util.Random;

public class Point {
    private static final Random random = new Random();
    private final boolean point;

    public Point() {
        this.point = random.nextBoolean();
    }

    public Point(Point previousPoint) {
        this.point = !previousPoint.point && random.nextBoolean();
    }

    public boolean isPoint() {
        return point;
    }
}
