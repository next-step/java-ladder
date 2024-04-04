package nextstep.ladder.domain.line;

import nextstep.ladder.utils.RandomGenerator;

public class Point {

    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isPointFalse() {
        return !point;
    }

    public int moveNextPoint() {
        return point ? 1 : -1;
    }

    public Point decideNextPoint() {
        if (!point) {
            return new Point(RandomGenerator.createRandomBoolean());
        }
        return new Point(false);
    }
}
