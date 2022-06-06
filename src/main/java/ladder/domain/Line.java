package ladder.domain;

import ladder.strategy.LineStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(List<Point> points) {
        validateEmpty(points);
        validateOverlap(points);

        return new Line(points);
    }

    private static void validateEmpty(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("좌표값들이 존재하지 않습니다.");
        }
    }

    private static void validateOverlap(List<Point> points) {
        int bound = points.size() - 1;
        for (int i = 0; i < bound; i++) {
            compareWithNextPoint(points, i);
        }
    }

    private static void compareWithNextPoint(List<Point> points, int index) {
        Point point = points.get(index);
        Point nextPoint = points.get(index + 1);

        if (point.overlapped(nextPoint)) {
            throw new IllegalArgumentException("라인 겹치는 경우는 존재할 수 없습니다.");
        }
    }

    public static Line from(List<Boolean> points) {
        return Line.create(IntStream.range(0, points.size()).mapToObj(i -> Point.of(i, points.get(i))).collect(Collectors.toList()));
    }

    public static Line from(Boolean... points) {
        return Line.from(List.of(points));
    }

    public static Line of(int countOfParticipants, LineStrategy lineStrategy) {
        return Line.from(lineStrategy.initialPoints(countOfParticipants));
    }

    public Position movedFrom(Position position) {
        Point currentPoint = points.get(position.now());
        return currentPoint.moved(points);
    }

    public int countOfParticipants() {
        return this.points.size();
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
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

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
