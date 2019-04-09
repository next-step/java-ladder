package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final Integer MIN_CREATABLE_LINE_LENGTH = 2;

    private List<Point> points = new ArrayList<>();

    private Line(List<Boolean> booleans) {
        points.add(Point.first(booleans.get(0)));

        for (int i = 1; i < booleans.size() - 1; i++) {
            Point point = Point.next(points.get(i - 1), booleans.get(i));
            points.add(point);
        }

        points.add(Point.last(points.get(points.size() - 1)));
    }

    public static Line newLine(int length, Supplier<Boolean> booleanGenerator) {
        if(length < MIN_CREATABLE_LINE_LENGTH) {
            throw new IllegalArgumentException();
        }

        return new Line(IntStream.range(0, length)
            .mapToObj(i -> booleanGenerator.get())
            .collect(Collectors.toList()));
    }


    public Integer move(Integer location) {
        Point current = points.get(location - 1);

        if(current.rightMovable()) {
            return location + 1;
        }

        if(current.leftMovable()) {
            return location - 1;
        }

        return location;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point);
            sb.append(point.rightMovable() ? "-----" : "     ");
        }

        return sb.toString();
    }
}
