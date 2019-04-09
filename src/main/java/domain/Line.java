package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {


    private List<Point> points = new ArrayList<>();

    private Line(List<Boolean> booleans) {
        points.add(Point.first(booleans.get(0)));

        for (int i = 1; i < booleans.size() - 1; i++) {
            Point point = Point.next(points.get(i - 1), booleans.get(i));
            points.add(point);
        }

        points.add(Point.last(booleans.size()));
    }

    public static Line newLine(int length, Supplier<Boolean> booleanGenerator) {
        return new Line(IntStream.range(0, length)
            .mapToObj(i -> booleanGenerator.get())
            .collect(Collectors.toList()));
    }


    public Integer move(Integer location) {
        if(canMoveRight(location)) {
            return location + 1;
        }

        if(canMoveLeft(location)) {
            return location - 1;
        }

        return location;
    }

    private boolean canMoveRight(Integer location) {
        return points.get(location - 1).isMovable();
    }

    private boolean canMoveLeft(Integer location) {
        return location >= 2 && points.get(location - 2).isMovable();
    }

    public boolean contains(Point point) {
        return points.contains(point);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point);
            sb.append(point.isMovable() ? "-----" : "     ");
        }

        return sb.toString();
    }
}
