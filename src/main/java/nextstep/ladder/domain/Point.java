package nextstep.ladder.domain;

import java.util.Random;

public class Point {
    private final static Random random = new Random();
    private final boolean point;

    public Point() {this.point = random.nextBoolean();}

    public Point(boolean point) {
        this.point = point;
    }

    public boolean getValue() {
        return this.point;
    }

    public Point createNextPoint() {
        return new Point(!this.point && random.nextBoolean());
    }
}
