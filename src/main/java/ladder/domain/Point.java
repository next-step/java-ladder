package ladder.domain;

public class Point {
    public static final int NEXT_INDEX = 1;
    private static final int MINIMUM_INDEX = 0;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        validateIndex(index);
        this.index = index;
        this.direction = direction;
    }

    public static Point drawFirstPoint(boolean isDown) {
        return isDown ? new Point(MINIMUM_INDEX, Direction.DOWN) : new Point(MINIMUM_INDEX, Direction.RIGHT);
    }

    public static Point drawMiddlePoint(Point lastPoint, boolean isDown) {
        if (lastPoint.isConnected()) {
            return new Point(lastPoint.index + NEXT_INDEX, Direction.LEFT);
        }
        return isDown ? new Point(lastPoint.index + NEXT_INDEX, Direction.DOWN)
                : new Point(lastPoint.index + NEXT_INDEX, Direction.RIGHT);
    }

    public static Point drawLastPoint(Point lastPoint) {
        return lastPoint.isConnected() ? new Point(lastPoint.index + NEXT_INDEX, Direction.LEFT)
                : new Point(lastPoint.index + NEXT_INDEX, Direction.DOWN);
    }

    private boolean isConnected() {
        return direction == Direction.RIGHT;
    }

    private void validateIndex(int index) {
        if (index < MINIMUM_INDEX) {
            throw new LadderBuildingException(LadderBuildingException.NEGATIVE_INDEX);
        }
    }

    public int moveByDirection() {
        return direction.moveIndexByDirection(index);
    }

    public Direction getDirection() {
        return direction;
    }
}
