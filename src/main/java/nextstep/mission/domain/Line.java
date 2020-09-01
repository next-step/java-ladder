package nextstep.mission.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        validate(points);
        this.points = points;
    }

    public Line(int size) {
        this(createPoints(size));
    }

    public List<Point> getPoints() {
        return points;
    }

    private static List<Point> createPoints(int size) {
        List<Point> result = new ArrayList<>();
        boolean value = false;

        for (int index = 0; index < size; index++) {
            if (index != 0) {
                value = RandomPoint.next(value);
            }

            result.add(Point.of(value));
        }

        return result;
    }

    private void validate(List<Point> points) {
        IntStream.range(0, points.size() - 1)
                .forEach(index -> validPoint(points.get(index), points.get(index + 1)));
    }

    private void validPoint(Point point1, Point point2) {
        if (point1.equals(Point.of(true)) && point2.equals(Point.of(true))) {
            throw new IllegalArgumentException("선은 겹칠수 없습니다.");
        }
    }

    public boolean checkSize(int size) {
        return this.points.size() == size;
    }

    public int move(int currentPosition) {
        Point current = getPoint(currentPosition);
        Point next = getPoint(currentPosition + 1);

        if (next != null && next.toBoolean()) {
            return 1;
        }

        if (current.toBoolean()) {
            return -1;
        }

        return 0;
    }

    public Point getPoint(int position) {
        if (position < 0 || points.size() <= position)
            return null;

        return points.get(position);
    }

    public int nextPosition(int currentPosition) {
        return currentPosition + move(currentPosition);
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

    @Override
    public String toString() {
        return Arrays.toString(points.toArray());
    }

}