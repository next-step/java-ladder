package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line(int size) {
        this(sizeToPointList(size));
    }

    public static List<Point> sizeToPointList(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> new Point())
                .collect(Collectors.toList());
    }

    public boolean hasBridgeAtPosition(int position) {
        Point point = points.get(position);
        return point.hasTrue();
    }

    public void putBridgeAtPosition(int position) {
        Point point = points.get(position);
        Point nextPoint = points.get(position + 1);
        point.connectRight();
        nextPoint.connectLeft();
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
