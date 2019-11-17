package nextstep.ladder.domain;

import nextstep.UniformRandomBooleanProvider;

public class Point {

    private final int index;
    private final boolean hasLine;
    private final Point previousPoint;

    public Point(int index, boolean hasLine, Point previousPoint) {
        this.index = index;
        this.hasLine = hasLine;
        this.previousPoint = previousPoint;
    }

    public static Point createFirst() {
        return new Point(0, UniformRandomBooleanProvider.getInstance().get(), null);
    }

    public Point createNext() {
        if (hasLine) {
            return new Point(index + 1, false, this);
        }
        return new Point(index + 1, UniformRandomBooleanProvider.getInstance().get(), this);
    }

    public Point createLast() {
        return new Point(index + 1, false, this);
    }

    public boolean hasLine() {
        return hasLine;
    }

    public int move() {
        if (previousPoint != null && previousPoint.hasLine()) {
            return index - 1;
        }

        if (hasLine) {
            return index + 1;
        }

        return index;
    }
}
