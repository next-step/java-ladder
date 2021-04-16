package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;

import java.util.Objects;

public class CrossingPoint {
    private final int index;
    private final Point point;

    private CrossingPoint(int index, Point point) {
        this.index = index;
        this.point = point;
    }

    public static CrossingPoint first(DirectionStrategy directionStrategy) {
        return new CrossingPoint(0, Point.first(directionStrategy));
    }

    public int move() {
        return point.move();
    }

    public Point point() {
        return point;
    }

    public boolean isNotLast(int totalSize) {
        return index + 1 != totalSize - 1;
    }

    public CrossingPoint next(DirectionStrategy directionStrategy) {
        return new CrossingPoint(index + 1, point.next(directionStrategy));
    }


    public CrossingPoint last() {
        return new CrossingPoint(index + 1, point.last());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrossingPoint crossingPoint = (CrossingPoint) o;
        return index == crossingPoint.index &&
                Objects.equals(point, crossingPoint.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, point);
    }
}
