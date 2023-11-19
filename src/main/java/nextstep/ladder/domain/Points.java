package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Points {

    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public static List<Point> drawFirst(boolean mayBeDraw) {
        return new ArrayList<>(List.of(Point.first(mayBeDraw)));
    }

    public List<Point> drawNext(Point point,
                                boolean mayBeDraw) {
        List<Point> list = new ArrayList<>(this.points);
        list.add(point.draw(mayBeDraw));
        return List.copyOf(list);
    }

    public List<Point> drawLast(Point point) {
        List<Point> list = new ArrayList<>(this.points);
        list.add(point.last());
        return List.copyOf(list);
    }

    public Direction nextDirection(int point) {
        Point currentPoint = this.points.get(point);
        return currentPoint.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
