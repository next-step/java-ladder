package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Point> points;

    public Line(int numberOfPerson) {
        this.points = new ArrayList<>();
        this.points.add(new Point(false));
        for (int i = 1; i < numberOfPerson; i++) {
            final Point previousPoint = this.points.get(i - 1);
            this.points.add(new Point(previousPoint));
        }
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Point point : points) {
            stringBuilder.append(point.print());
        }
        return stringBuilder.append("\n").toString();
    }


    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
