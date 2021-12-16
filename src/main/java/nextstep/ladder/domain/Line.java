package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class Line extends FirstClassList<Boolean> {
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

    public List<Integer> nextPosition(List<Integer> position) {
        return position.stream()
                .map(this::move)
                .collect(Collectors.toList());
    }

    public int move(int index) {
        // todo refactoring
        if (index < size() && get(index)) {
            return index + 1;
        }

        if (index != 0 && get(index - 1)) {
            return index - 1;
        }

        return index;
    }

    @Override
    public String toString() {
        return "Line {" +
                super.toString() +
                '}';
    }
}
