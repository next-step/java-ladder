package nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(LineCreateStrategy strategy, int peopleCount) {
        List<Point> points = strategy.create(peopleCount);
        this.points = points;
    }

    public Line(List<Boolean> points) {
        this.points = toPoints(points);
    }

    private List<Point> toPoints(List<Boolean> points) {
        List<Point> result = new ArrayList<>();
        Point point = Point.first(points.get(0));
        result.add(point);
        for (int i = 1; i < points.size(); i++) {
            point = point.next(points.get(i));
            result.add(point);
        }
        result.add(point.last());
        return result;
    }

    public Direction getDirection(int point) {
        return points.get(point).move();
    }

    public List<Point> getPoints() {
        return points;
    }
}
