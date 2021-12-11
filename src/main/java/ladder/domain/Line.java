package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {
    private List<Point> points = new ArrayList<>();
    private Random random = new Random();

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line(int countOfUser) {
        boolean left = random.nextBoolean();
        points.add(Point.firstPoint(left));
        for (int i = 1; i < countOfUser - 1; i++) {
            Point point = new Point(left, random.nextBoolean());
            points.add(point);
            left = point.getCurrent();
        }
        points.add(Point.lastPoint(left));
    }

    public List<Point> getPoints() {
        return points;
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
