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

    public boolean isPointTrue() {
        return point;
    }

    public Point decideNextPoint() {
        if (!point) {
            return new Point(RandomGenerator.createRandomBoolean());
        }
        return new Point(false);
    }
}
