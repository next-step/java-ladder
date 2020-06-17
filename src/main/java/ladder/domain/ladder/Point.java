package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

public class Point {

    private final boolean hasLine;

    private Point(boolean hasLine) {
        this.hasLine = hasLine;
    }

    public static Point createFirstPoint(LineStrategy lineStrategy) {
        return new Point(lineStrategy.hasLine());
    }

    public static Point createMiddlePoint(Point previousPoint, LineStrategy lineStrategy) {
        if (previousPoint.hasLine()) {
            return new Point(false);
        }
        return new Point(lineStrategy.hasLine());
    }

    public static Point createLastPoint() {
        return new Point(false);
    }

    public boolean hasLine() {
        return hasLine;
    }
}
