package nextstep.ladder.domain;

import nextstep.ladder.exception.ContinuousRowException;

public class Point {
    private final boolean point;

    private Point(boolean point) {
        this.point = point;
    }

    public static Point from(boolean point) {
        return new Point(point);
    }

    public Point next(boolean point) {
        if (this.point && point) {
            return new Point(Boolean.FALSE);
        }
        return new Point(point);
    }

    public boolean isTrue() {
        return point;
    }

    public void checkNextPoint(Point next) {
        if (this.point && next.point) {
            throw new ContinuousRowException();
        }
    }
}
