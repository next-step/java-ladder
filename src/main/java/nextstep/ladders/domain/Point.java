package nextstep.ladders.domain;

import nextstep.ladders.domain.strategy.DirectionGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static List<Point> toList(final DirectionGenerator directionGenerator, final int numberOfPeople) {
        if (numberOfPeople == 1) {
            return Collections.singletonList(Point.first(directionGenerator.generate()));
        }
        List<Point> points = new ArrayList<>();
        points.addAll(initFirst(directionGenerator));
        points.addAll(initMiddle(directionGenerator, numberOfPeople, points.get(points.size() - 1)));
        points.addAll(initLast(points.get(points.size() - 1)));
        return points;
    }

    private static List<Point> initLast(final Point point) {
        return Collections.singletonList(point.last());
    }

    private static List<Point> initMiddle(final DirectionGenerator directionGenerator, final int numberOfPeople, final Point point) {
        Point next = new Point(point.index, point.direction);
        List<Point> points = new ArrayList<>();

        for (int i = 1; i < numberOfPeople - 1; i++) {
            next = next.next(directionGenerator.generate());
            points.add(next);
        }
        return points;
    }

    private static List<Point> initFirst(final DirectionGenerator directionGenerator) {
        return Collections.singletonList(Point.first(directionGenerator.generate()));
    }

    private static Point first(final Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point last() {
        return new Point(this.index + 1, this.direction.last());
    }

    public Point next(final Boolean right) {
        return new Point(this.index + 1, this.direction.next(right));
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }
        if (direction.isLeft()) {
            return index - 1;
        }
        return index;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
