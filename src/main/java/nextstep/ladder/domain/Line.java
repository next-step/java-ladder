package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class Line {
    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static Line of (final PointCount count, final LineGenerateStrategy strategy) {
        if (strategy == null || count == null) {
            throw new IllegalArgumentException("invalid input: count or strategy cannot be null");
        }

        // todo 길이 검증을 generate 안으로 넣자
        List<Boolean> points = strategy.generate(count);

        if (points.size() != count.toInt()) {
            throw new IllegalArgumentException("invalid line: generated size is not match");
        }

        return new Line(points);
    }

    public static Line of(final PlayerCount playerCount, final LineGenerateStrategy strategy) {
        return of(PointCount.of(playerCount), strategy);
    }

    public static Line of(final int count, final LineGenerateStrategy strategy) {
        return of(PointCount.of(count), strategy);
    }

    public Stream<Boolean> stream() {
        return points.stream();
    }

    public List<Integer> nextPosition(List<Integer> position) {
        return position.stream()
                .map(this::move)
                .collect(Collectors.toList());
    }

    public int move(int index) {
        // todo refactoring
        if (index < points.size() && points.get(index)) {
            return index + 1;
        }

        if (index != 0 && points.get(index - 1)) {
            return index - 1;
        }

        return index;
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
