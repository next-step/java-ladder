package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class Line {
    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static Line of (final LineCount lineCount, final LineGenerateStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("invalid strategy: cannot be null");
        }

        if (lineCount == null) {
            throw new IllegalArgumentException("invalid player count: cannot be null");
        }

        List<Boolean> points = strategy.generate(lineCount);

        if (points.size() != lineCount.toInt()) {
            throw new IllegalArgumentException("invalid line: generated size is not match");
        }

        return new Line(points);

    }

    public static Line of(final PlayerCount playerCount, final LineGenerateStrategy strategy) {
        return of(LineCount.of(playerCount), strategy);
    }

    public static Line of(final int playerCount, final LineGenerateStrategy strategy) {
        return of(PlayerCount.of(playerCount), strategy);
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

    public Stream<Boolean> stream() {
        return points.stream();
    }
}
