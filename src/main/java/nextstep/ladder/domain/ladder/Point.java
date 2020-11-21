package nextstep.ladder.domain.ladder;

public class Point {
    private final Direction direction;
    private final Position position;

    public Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point of(Position position, Direction direction) {
        return new Point(position, direction);
    }

    public static Point first(int maxPosition, boolean right) {
        return new Point(Position.first(maxPosition), Direction.first(right));
    }

    public int getPosition() {
        return position.getCurrentPosition();
    }

    public int move() {
        if (direction.isLeft()) {
            return position.getPreviousPosition();
        }
        if (direction.isRight()) {
            return position.getNextPosition();
        }
        return getPosition();
    }

    public Point next(boolean right) {
        Position nextPosition = position.next();
        return new Point(nextPosition, direction.next(nextPosition.isLast(), right));

    }

    public boolean hasLeft() {
        return direction.isLeft();
    }

    public boolean hasRight() {
        return direction.isRight();
    }
}
