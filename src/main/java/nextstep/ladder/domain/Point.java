package nextstep.ladder.domain;

import java.util.Random;

public class Point {
    private static final String STICK = "|";
    private static final String EDGE = "-----";
    private static final String EMPTY = "     ";

    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public static Point of(Random random) {
        return new Point(random.nextBoolean());
    }

    public boolean isTrue() {
        return this.point == true;
    }

    public boolean isFalse() {
        return this.point == false;
    }

    public String getEdgeOrEmpty() {
        if (this.point) {
            return STICK + EDGE;
        }

        return STICK + EMPTY;
    }

}
