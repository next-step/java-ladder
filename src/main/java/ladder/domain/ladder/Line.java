package ladder.domain.ladder;

import ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line createLine(int countOfPlayers, LineStrategy strategy)  {
        List<Point> points = new ArrayList<>();
        Point point = createFirstPoint(strategy, points);
        for (int i = 1; i < countOfPlayers - 1; i++) {
            point = Point.middle(point, strategy.isEnableLine());
            points.add(point);
        }
        createLastPoint(points, point);
        return new Line(points);
    }

    private static Point createFirstPoint(LineStrategy strategy, List<Point> points) {
        Point point = Point.first(strategy.isEnableLine());
        points.add(point);
        return point;
    }

    private static void createLastPoint(List<Point> points, Point point) {
        point = Point.last(point);
        points.add(point);
    }

    public int move(int index) {
        index = points.get(index).move();
        return index;
    }

    public List<Point> getLiens() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return points + " ";
    }

}
