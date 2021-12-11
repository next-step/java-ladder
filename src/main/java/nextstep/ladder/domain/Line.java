package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class Line {
    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static Line of(final int numberOfPlayer, final LineGenerateStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("invalid strategy: cannot be null");
        }

        List<Boolean> points = strategy.generate(numberOfPlayer);
        return new Line(points);
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
