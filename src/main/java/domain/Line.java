package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validate(points);
        this.points = points;
    }

    public Line(int columnCount, ConnectionStrategy strategy) {
        this(generateLine(columnCount, strategy));
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private static List<Boolean> generateLine(int columnCount, ConnectionStrategy strategy) {
        List<Boolean> line = new ArrayList<>();

        for (int i = 0; i < columnCount - 1; i++) {
            tryAddConnection(i, line, strategy);
        }

        return line;
    }

    private static void tryAddConnection(int i, List<Boolean> line, ConnectionStrategy strategy) {
        if (isPreviousConnected(i, line)) {
            line.add(false);
            return;
        }
        line.add(strategy.shouldConnect());
    }

    private static boolean isPreviousConnected(int i, List<Boolean> line) {
        return i > 0 && line.get(i - 1);
    }

    private void validate(List<Boolean> points) {
        validateEmpty(points);
        validateConsecutiveTrues(points);
    }

    private void validateEmpty(List<Boolean> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("라인은 비어있을 수 없습니다.");
        }
    }

    private void validateConsecutiveTrues(List<Boolean> points) {
        IntStream.range(1, points.size())
            .filter(i -> points.get(i) && points.get(i - 1))
            .findAny()
            .ifPresent(i -> {
                throw new IllegalArgumentException("라인은 이어질 수 없습니다.");
            });
    }
}
