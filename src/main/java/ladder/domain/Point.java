package ladder.domain;

import ladder.Position;
import ladder.domain.strategy.GeneratorInterface;

public class Point {
    private Position position;
    private Direction direction;

    public Point(Position position, Direction direction) {
        this.position = position.next();
        this.direction = direction;
    }

    public static Point first(boolean current) {
        return new Point(new Position(0), Direction.first(current));
    }

    public Point next(boolean right) {
        return new Point(getNextIndex(), direction.next(right));
    }

    public Point next(GeneratorInterface strategy) {
        if (direction.isRight()) {
            return next(false);
        }

        return next(strategy.generate());
    }

    public Point last() {
        return new Point(getNextIndex(), direction.last());
    }

    public int move() {
        return direction.move(position).toInt();
    }

    public boolean current() {
        return direction == Direction.RIGHT;
    }

    private Position getNextIndex() {
        return position.next();
    }
}
