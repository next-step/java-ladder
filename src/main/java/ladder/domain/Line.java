package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int REQUIRED_NUMBER_OF_PEOPLE = 1;
    private static final int MOVING_DISTANCE = 1;

    private final List<Point> points;

    public static Line of(int countOfPerson) {

        List<Point> points = new ArrayList<>();
        points.add(Point.first());
        Point point = Point.first();

        for (int i = REQUIRED_NUMBER_OF_PEOPLE; i < countOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());

        return new Line(points);
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    private Line(List<Point> points) {
        this.points = points;
    }

    public int getSize() {
        return points.size();
    }

    public int movedPosition(int position) {
        Direction direction = points.get(position).movedDirection();

        if (direction == Direction.RIGHT) {
            return position + MOVING_DISTANCE;
        }

        if (direction == Direction.LEFT) {
            return position - MOVING_DISTANCE;
        }

        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
