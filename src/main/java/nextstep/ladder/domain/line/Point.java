package nextstep.ladder.domain.line;

import nextstep.ladder.domain.RandomGenerator;

public class Point {

    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isLadderConstructionStatusFalse() {
        return !point;
    }

    public Point decideNextPoint() {
        if (point) {
            return new Point(RandomGenerator.createRandomBoolean());
        }
        return new Point(false);
    }
}
