package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder of(final PointCount pointCount, final Height height, LineGenerateStrategy strategy) {
        if (pointCount == null || height == null) {
            throw new IllegalArgumentException("invalid input: cannot be null");
        }

        return new Ladder(Stream.generate(() -> Line.of(pointCount, strategy))
                .limit(height.toInt())
                .collect(Collectors.toList()));
    }

    public static Ladder of(final PointCount pointCount, final int height, final LineGenerateStrategy strategy) {
        return Ladder.of(pointCount, Height.of(height), strategy);
    }

    public static Ladder of(final PlayerCount playerCount, final Height height, final LineGenerateStrategy strategy) {
        return Ladder.of(PointCount.of(playerCount), height, strategy);
    }

    public Stream<Line> stream() {
        return lines.stream();
    }

    public ResultOfGame result(Players players, Results results) {
        List<Integer> indexMap = IntStream.range(0, players.count().toInt())
                .boxed()
                .collect(Collectors.toList());

        // todo stream으론 못바꿀까?
        for (Line line : lines) {
            indexMap = line.nextPosition(indexMap);
        }

        return ResultOfGame.of(players, results, indexMap);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
