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
        // TODO 사람 못찾을 때
        if (numberOfPeople == 1) {
            return Collections.singletonList(Point.first(directionGenerator.generate()));
        }
        List<Point> points = new ArrayList<>();
        Point point = initFirst(directionGenerator, points);
        point = initMiddle(directionGenerator, numberOfPeople, points, point);
        initLast(points, point);
        return points;
    }

    private static void initLast(List<Point> points, Point point) {
        points.add(point.last());
    }

    private static Point initMiddle(DirectionGenerator directionGenerator, int numberOfPeople, List<Point> points, Point point) {
        for (int i = 1; i < numberOfPeople - 1; i++) {
            point = point.next(directionGenerator.generate());
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(DirectionGenerator directionGenerator, List<Point> points) {
        Point point = Point.first(directionGenerator.generate());
        points.add(point);
        return point;
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
