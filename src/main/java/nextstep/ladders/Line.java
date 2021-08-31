package nextstep.ladders;

import nextstep.ladders.exception.InvalidLineSizeException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private final List<Point> points;

    public Line(final List<Point> points) {
        this.points = points;
    }

    public Line(final Generator generator, final int numberOfPeople) {
        this(Point.toList(generator, numberOfPeople));
    }

    public static List<Line> toList(final Generator generator, int height, int numberOfPeople) {
        return Stream.generate(() -> new Line(generator, numberOfPeople))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int move(int index) {
        checkValidIndex(index);
        Point point = points.get(index);
        return point.move();
    }

    private void checkValidIndex(final int index) {
        if (index < 0 || index >= points.size()) {
            throw new InvalidLineSizeException();
        }
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
