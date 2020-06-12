package ladder.domain;

public class Point {
    private static final int MINIMUM_INDEX = 0;
    private static final int NEXT_INDEX = 1;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        validateIndex(index);
        this.index = index;
        this.direction = direction;
    }

    public static Point drawFirstPoint(boolean isDown) {
        if (isDown) {
            return new Point(MINIMUM_INDEX, Direction.DOWN);
        }
        return new Point(MINIMUM_INDEX, Direction.RIGHT);
    }

    public static Point drawMiddlePoint(Point lastPoint, boolean isDown) {
        if (lastPoint.direction == Direction.RIGHT) {
            return new Point(lastPoint.index + NEXT_INDEX, Direction.LEFT);
        }
        if (isDown) {
            return new Point(lastPoint.index + NEXT_INDEX, Direction.DOWN);
        }
        return new Point(lastPoint.index + NEXT_INDEX, Direction.RIGHT);
    }

    public static Point drawLastPoint(Point lastPoint) {
        if (lastPoint.direction == Direction.RIGHT) {
            return new Point(lastPoint.index + NEXT_INDEX, Direction.LEFT);
        }
        return new Point(lastPoint.index + NEXT_INDEX, Direction.DOWN);
    }

    public int moveByDirection() {
        return direction.moveIndexByDirection(index);
    }

    private void validateIndex(int index) {
        if (index < MINIMUM_INDEX) {
            throw new LadderBuildingException(LadderBuildingException.NEGATIVE_INDEX);
        }
    }

    public Direction getDirection() {
        return direction;
    }
}
