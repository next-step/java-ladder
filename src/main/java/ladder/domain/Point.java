package ladder.domain;

import java.util.Random;

public class Point {

    private static final Random random;
    private final Way way;

    static {
        random = new Random();
    }

    public Point() {
        this.way = init();
    }

    public Point(Way way) {
        this.way = way;
    }

    public Point(Point leftPoint, boolean possibleRight) {
        if (Way.RIGHT.equals(leftPoint.getWay())) {
            this.way = Way.LEFT;
            return;
        }
        if (possibleRight) {
            this.way = init();
            return;
        }
        this.way = Way.DOWN;
    }

    private Way init() {
        boolean right = random.nextBoolean();
        if (right) {
            return Way.RIGHT;
        }
        return Way.DOWN;
    }

    public int nextLocation(int location) {
        return this.way.getDestination() + location;
    }

    public Way getWay() {
        return way;
    }
}
