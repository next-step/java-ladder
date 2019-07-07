package ladder.domain;

import ladder.domain.strategy.GeneratorInterface;

public class Point {
    private int position;
    private Direction direction;

    public Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point first(boolean current) {
        return new Point(0, Direction.first(current));
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
        return direction.move(position);
    }

    public boolean current() {
        return direction == Direction.RIGHT;
    }

    private int getNextIndex() {
        return position + 1;
    }
}
