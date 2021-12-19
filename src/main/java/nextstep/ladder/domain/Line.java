package nextstep.ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class Line extends FirstClassList<Boolean> {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    private Line(final List<Boolean> points) {
        super(points);
    }

    public static Line of (final PointCount count, final LineGenerateStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("invalid input: strategy cannot be null");
        }

        return new Line(strategy.generate(count));
    }

    public static Line of(final PlayerCount playerCount, final LineGenerateStrategy strategy) {
        return of(PointCount.of(playerCount), strategy);
    }

    public static Line of(final int count, final LineGenerateStrategy strategy) {
        return of(PointCount.of(count), strategy);
    }

    public List<Integer> move(List<Integer> position) {
        return position.stream()
                .map(this::nextPosition)
                .collect(Collectors.toList());
    }

    int nextPosition(int index) {
        return hasPoint(index).map(point -> index + RIGHT)
                .orElse(hasPoint(index + LEFT).map(p -> index + LEFT)
                        .orElse(index));
    }

    Optional<Boolean> hasPoint(int index) {
        return elementOfOpt(index).filter(p -> p);
    }

    @Override
    public String toString() {
        return "Line {" +
                super.toString() +
                '}';
    }
}
