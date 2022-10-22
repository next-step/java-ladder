package ladder.model;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public Point next(boolean rightRandom) {
        if (direction.isConnectableNext()) {
            return new Point(index + 1, direction.next(rightRandom));
        }

        return new Point(index + 1, direction.next());
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public Direction getDirection() {
        return direction;
    }
}
