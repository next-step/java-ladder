package ladder.domain;

import ladder.strategy.MovableStrategy;

public class Point {
    private final boolean isExistLeft;
    private final boolean isExistRight;

    private Point(boolean isExistLeft, boolean isExistRight) {
        this.isExistLeft = isExistLeft;
        this.isExistRight = isExistRight;
    }

    public static Point fromMiddle(Point point, MovableStrategy movableStrategy) {
        if (point.existLeft()) {
            return Point.of(false, false);
        }
        return Point.of(movableStrategy.isMovable(), false);
    }

    public static Point of(boolean isExistLeftBridge, boolean isExistRightBridge) {
        return new Point(isExistLeftBridge, isExistRightBridge);
    }

    public static Point of(MovableStrategy leftMovableStrategy, MovableStrategy rightMovableStrategy) {
        return new Point(leftMovableStrategy.isMovable(), rightMovableStrategy.isMovable());
    }

    public boolean existLeft() {
        return isExistLeft;
    }

    public boolean existRight() {
        return isExistRight;
    }
}
