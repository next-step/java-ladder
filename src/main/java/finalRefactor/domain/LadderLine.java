package finalRefactor.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;

    public LadderLine() {
        points = new ArrayList<>();
    }

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public Point first(PositionGenerator positionGenerator) {
        Point first = Point.first(positionGenerator.generate());
        points.add(first);
        return first;
    }

    public void body(int countOfPerson, Point point) {
        for (int i = 1; i < countOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
    }

    public void tail(Point point) {
        points.add(point.last());
    }

    public Point get(int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
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
