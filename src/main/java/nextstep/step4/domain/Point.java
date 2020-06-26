package nextstep.step4.domain;

public class Point {
    private int index;
    private Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean moveable) {
        return new Point(0, Direction.firstPositionDirection(moveable));
    }

    public Point next(boolean moveable) {
        return new Point(index + 1, direction.next(moveable));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public int move() {
        if (direction.isRight()) {
            return index += 1;
        }

        if (direction.isLeft()) {
            return index -= 1;
        }

        return index;
    }

    public Direction getDirection() {
        return direction;
    }
}
