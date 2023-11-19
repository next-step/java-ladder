package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Points {

    private List<Point> points;

    public Points(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public static Points drawFirst(boolean mayBeDraw) {
        return new Points(List.of(Point.first(mayBeDraw)));
    }

    public void drawNext(boolean mayBeDraw) {
        List<Point> list = new ArrayList<>(this.points);
        list.add(getLast().draw(mayBeDraw));
        this.points = list;
    }

    public void drawLast() {
        List<Point> list = new ArrayList<>(this.points);
        list.add(getLast().last());
        this.points = List.copyOf(list);
    }

    private Point getLast() {
        return points.get(points.size() - 1);
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
