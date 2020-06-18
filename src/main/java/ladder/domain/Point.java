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
        return new Point(MINIMUM_INDEX, Direction.first(isDown));
    }

    public Point drawLastPoint() {
        return new Point(this.index + NEXT_INDEX, this.direction.last());
    }

    public Point drawNextPoint(boolean isDown) {
        return new Point(this.index + NEXT_INDEX, this.direction.next(isDown));
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
