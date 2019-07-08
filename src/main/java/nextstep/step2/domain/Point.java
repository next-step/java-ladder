package nextstep.step2.domain;

import java.util.Objects;

public class Point {
    private final int index;
    private final Directions directions;

    public Point(int index, Directions directions) {
        this.index = index;
        this.directions = directions;
    }

    public static Point createFirst(final PointCreationStrategy strategy) {
        return new Point(0, Directions.createFirst(strategy));
    }

    public Point createNext(final PointCreationStrategy strategy) {
        return new Point(this.index + 1, Directions.createNext(strategy, directions.isRightLine()));
    }

    public Point createLast() {
        return new Point(this.index + 1, Directions.createLast(directions.isRightLine()));
    }

    public int move() {
        return directions.move(index);
    }

    public int getIndex() {
        return index;
    }

    public Directions getDirections() {
        return directions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Point point = (Point) o;
        return index == point.index &&
            Objects.equals(directions, point.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, directions);
    }
}
