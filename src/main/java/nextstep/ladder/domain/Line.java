package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line(List<Boolean> points,
                int a) {
        List<Point> list = new ArrayList<>();

        Point point = Point.first(points.get(0));
        list.add(point);
        for (int i = 1; i < points.size() - 1; i++) {
            point = point.draw(points.get(i));
            list.add(point);
        }
        list.add(point.last());

        this.points = new ArrayList<>(list);
    }

    public List<Point> getAll() {
        return this.points;
    }

    public Direction nextDirection(int point) {
        return this.points.get(point).move();
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
