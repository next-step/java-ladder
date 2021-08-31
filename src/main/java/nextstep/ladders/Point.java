package nextstep.ladders;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static List<Point> toList(final Generator generator, final int numberOfPeople) {
        List<Point> points = new ArrayList<>();

        int index = 0;
        Direction direction = Direction.first(generator.generate());
        points.add(new Point(index, direction));

        while (index < numberOfPeople - 1) {
            index++;
            direction = direction.next(generator.generate());
            points.add(new Point(index, direction));
        }

        points.add(new Point(index, direction.last()));
        return points;
    }

    public int move() {
        if (direction.isRight()) {
            return this.index + 1;
        }
        if (direction.isLeft()) {
            return this.index - 1;
        }
        return this.index;
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
