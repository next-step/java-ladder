package ladderinterface.concrete;


import ladderinterface.util.BooleanGenerator;
import ladderinterface.util.RandomGenerator;

import java.util.Objects;

public class Point {
    private static final BooleanGenerator DEFAULT_GENERATOR = new RandomGenerator();

    private final int position;
    private final Direction direction;
    private final BooleanGenerator generator;

    private Point(int position, Direction direction, BooleanGenerator generator) {
        this.position = position;
        this.direction = direction;
        this.generator = generator;
    }

    public static Point of(int position, Direction direction) {
        return of(position, direction, DEFAULT_GENERATOR);
    }

    public static Point of(int position, Direction direction, BooleanGenerator generator) {
        return new Point(position, direction, generator);
    }

    public static Point first(boolean current) {
        return of(0, Direction.first(current));
    }

    public static Point first(BooleanGenerator generator) {
        return of(0, Direction.first(generator.generate()), generator);
    }

    public Point last() {
        return new Point(position + 1, direction.last(), generator);
    }

    public Point next() {
        return new Point(position + 1, direction.next(generator), generator);
    }

    public Point next(boolean current) {
        return new Point(position + 1 , direction.next(current), generator);
    }

    public int move() {
        return direction.move(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
