package nextstep.ladder.model;

import java.util.Random;

public class Point {
    private final Random random = new Random();
    private final boolean point;

    public Point() {
        this.point = random.nextBoolean();
    }

    public Point(Point previousPoint) {
        this.point = !previousPoint.point && random.nextBoolean();
    }

    public boolean getValue() {
        return this.point;
    }
}
