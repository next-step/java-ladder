package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(Integer size, Lottery lottery) {
        points.add(Point.valueOf(1, lottery.test()));
        for (int i = 1; i < size - 1; i++) {
            points.add(points.get(points.size() - 1).next(lottery.test()));
        }
        points.add(Point.valueOf(size, false));
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
