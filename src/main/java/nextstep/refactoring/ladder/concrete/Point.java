package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.engine.Position;

public class Point {

    private final Position position;
    private final Direction direction;

    private Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point of(int position, Direction direction) {
        return new Point(Position.of(position), direction);
    }

    public static Point first() {
        return Point.of(0, Direction.first());
    }

    public Point last() {
        return Point.of(0, direction.last());
    }

    public Point next() {
        return new Point(position.getRight(), direction.next());
    }

    public Point next(Boolean right) {
        return new Point(position.getRight(), direction.next(right));
    }

    public Position traverse() {
        if (direction.isLeft())  {
            return position.getLeft();
        }

        if (direction.isRight()) {
            return position.getRight();
        }

        return position;
    }
}
