package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    public static final int MIN_COUNT = 1;

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Point> points) {
        validateSize(points);
        validatePoints(points);
        return new Line(points);
    }

    private static void validateSize(List<Point> points) {
        if (points.size() < MIN_COUNT) {
            throw new IllegalArgumentException("최소 1개 이상의 Point가 필요합니다.");
        }
    }

    private static void validatePoints(List<Point> points) {
        IntStream.range(0, points.size() - 1)
                .filter(index -> points.get(index).checkConnected(points.get(index + 1)))
                .findAny()
                .ifPresent(index -> {
                    throw new IllegalArgumentException("Point가 연속적으로 연결될 수 없습니다.");
                });
    }

    public boolean isSameSize(int size) {
        return points.size() == size;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return points.equals(line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
