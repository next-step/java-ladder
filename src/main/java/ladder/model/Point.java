package ladder.model;

public class Point {

    private final int index;
    private final Direction direction;

    public Point next(boolean rightRandom) {
        if (direction.isConnectableNext()) {
            return new Point(index + 1, direction.next(rightRandom));
        }

        return new Point(index + 1, direction.next());
    }

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public Direction getDirection() {
        return direction;
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }
}
