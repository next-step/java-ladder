package ladder.domain;

import ladder.strategy.GeneratorStrategy;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public boolean hasLeftDirectionLine() {
        return direction == Direction.LEFT;
    }

    public int move() {
        if (direction == Direction.RIGHT) {
            return index + 1;
        }

        if (direction == Direction.LEFT) {
            return index - 1;
        }
        return this.index;
    }

    public Point next(final GeneratorStrategy movingStrategy) {
        return new Point(index + 1, direction.next(movingStrategy));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(final GeneratorStrategy generatorStrategy) {
        return new Point(0, Direction.first(generatorStrategy));
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
