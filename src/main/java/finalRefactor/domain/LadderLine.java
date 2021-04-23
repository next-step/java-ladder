package finalRefactor.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public LadderLine(int countOfPerson) {
        this(createLine(countOfPerson, new RandomGenerator()));
    }

    public static List<Point> createLine(int countOfPerson, PositionGenerator positionGenerator) {
        List<Point> points = new ArrayList<>();
        Point first = Point.first(positionGenerator.generate());
        points.add(first);
        List<Point> body = body(countOfPerson, first);
        points.addAll(body);
        tail(points.get(countOfPerson - 2), points);
        return points;
    }

    private static List<Point> body(int countOfPerson, Point point) {

        List<Point> points = new ArrayList<>();
        for (int i = 1; i < countOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return points;
    }

    private static void tail(Point point, List<Point> points) {
        points.add(point.last());
    }

    public List<Point> row() {
        return Collections.unmodifiableList(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "" + points;
    }
}
