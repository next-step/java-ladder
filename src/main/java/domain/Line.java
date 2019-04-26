package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final Integer MIN_CREATABLE_LINE_LENGTH = 2;

    private final List<Point> points = new ArrayList<>();

    private Line(List<Boolean> booleans) {
        Point point = Point.first(booleans.remove(0));
        points.add(point);

        for (Boolean bool : booleans) {
            point = point.next(bool);
            points.add(point);
        }

        points.add(point.last());
    }

    public static Line newLine(List<Boolean> booleans) {
        if(booleans.size() < MIN_CREATABLE_LINE_LENGTH) {
            throw new IllegalArgumentException();
        }

        return new Line(booleans);
    }

    public Integer move(Integer location) {
        Point current = points.get(location - 1);

        return current.move();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        points.forEach(sb::append);

        return sb.toString();
    }
}
