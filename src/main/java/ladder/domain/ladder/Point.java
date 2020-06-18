package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

public class Point {

    public static final int MOVABLE_POSITION = 1;
    public static final int IMMOVABLE_POSITION = 0;

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

    public int getNextPosition(){
        if (hasLine()) {
            return MOVABLE_POSITION;
        }
        return IMMOVABLE_POSITION;
    }
}
