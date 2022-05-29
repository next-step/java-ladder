package ladder.domain.ladder;

import ladder.domain.point.Point;
import ladder.domain.point.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Point> points;

    public Line() {
        this(new ArrayList<>());
    }

    public Line(List<Point> points) {
        validate(points);
        this.points = new ArrayList<>(points);
    }

    private void validate(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("points는 null 일 수 없습니다.");
        }
    }

    private Line extend(Point point) {
        List<Point> points = new ArrayList<>(this.points);
        points.add(point);
        return new Line(points);
    }

    public static Line init(int width) {
        return new Line()
                .extendFirst()
                .extendBody(width - 1)
                .extendLast();
    }

    private Line extendFirst() {
        return extend(Point.first());
    }

    private Line extendBody(int targetWidth) {
        if (width() >= targetWidth) {
            return this;
        }

        return extend(
                getLastPoint().next()
        ).extendBody(targetWidth);
    }

    private Line extendLast() {
        return extend(getLastPoint().nextLast());
    }

    private Point getLastPoint() {
        return points.get(points.size() - 1);
    }

    public Position trace(Position position) {
        return points.stream()
                .filter(point -> point.isSamePosition(position))
                .map(point -> point.move(position))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사다리 위치가 올바르지 않습니다."));
    }

    private int width() {
        return points.size();
    }

    @Override
    public String toString() {
        return points.stream()
                .map(Point::toString)
                .collect(Collectors.joining());
    }
}
