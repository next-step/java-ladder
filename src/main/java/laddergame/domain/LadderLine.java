package laddergame.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine {

    public static final int MIN_NUMBER_OF_POINTS = 1;

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(List<Point> points) {
        validateSizeOfPoints(points);
        validatePointIndices(points);
        validatePointDirections(points);
        validateEndPoints(points);
    }

    private void validateSizeOfPoints(List<Point> points) {
        if (points.size() < MIN_NUMBER_OF_POINTS) {
            throw new IllegalArgumentException(String.format("포인트의 개수는 %d 이상이어야 합니다.", MIN_NUMBER_OF_POINTS));
        }
    }

    private void validatePointIndices(List<Point> points) {
        IntStream.range(0, points.size())
                .forEach(i -> {
                    Point point = points.get(i);
                    if (!point.isEqualIndex(i)) {
                        throw new IllegalArgumentException("포인트의 인덱스는 0 부터 순차적으로 1씩 증가해야 합니다.");
                    }
                });
    }

    private void validatePointDirections(List<Point> points) {
        if (points.isEmpty()) {
            return;
        }

        IntStream.range(1, points.size())
                .forEach(i -> {
                    Point previousPoint = points.get(i - 1);
                    Point nextPoint = points.get(i);
                    if (!nextPoint.nextPointPossible(previousPoint)) {
                        throw new IllegalArgumentException("포인트의 방향이 잘못되었습니다.");
                    }
                });
    }

    private void validateEndPoints(List<Point> points) {
        if (points.isEmpty()) {
            return;
        }

        Point firstPoint = points.get(0);
        Point lastPoint = points.get(points.size() - 1);
        if (!firstPoint.firstPossible() || !lastPoint.lastPossible(points.size())) {
            throw new IllegalArgumentException("양 끝의 포인트가 잘못되었습니다.");
        }
    }

    public static LadderLine from(Direction... directions) {
        List<Point> points = IntStream.range(0, directions.length)
                .mapToObj(i -> new Point(i, directions[i]))
                .collect(Collectors.toList());
        return new LadderLine(points);
    }

    public Point get(int index) {
        return points.get(index);
    }

    public int size() {
        return points.size() - 1;
    }

    public boolean isConnected(int indexOfConnection) {
        Point point = points.get(indexOfConnection);
        return point.isConnected(points.get(indexOfConnection + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }

}
