package ladder.domain;

public class Point {
    private static final int MINIMUM_INDEX = 0;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        validateIndex(index);
        this.index = index;
        this.direction = direction;
    }

    public static Point drawFirstPoint(int playerCounts, int index, boolean isDown) {
        if (playerCounts == 1 || isDown) {
            return new Point(index, Direction.DOWN);
        }
        return new Point(index, Direction.RIGHT);
    }

    public static Point drawMiddlePoint(int index, boolean isDown) {
        if (isDown) {
            return new Point(index, Direction.DOWN);
        }
        return new Point(index, Direction.RIGHT);
    }

    public static Point drawPoint(int index, int randomNumber) {
        return new Point(index, Direction.valueOf(randomNumber));
    }

    public static Point drawLastPoint(int index, boolean isDown) {
        if (isDown) {
            return new Point(index, Direction.DOWN);
        }
        return new Point(index, Direction.LEFT);
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
