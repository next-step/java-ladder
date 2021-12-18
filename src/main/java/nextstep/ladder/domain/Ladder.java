package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class Ladder extends FirstClassList<Line> {
    private Ladder(final List<Line> lines) {
        super(lines);
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

    public ResultOfGame result(Players players, Results results) {
        List<Integer> indexMap = downToResult(IntStream.range(0, players.size())
                        .boxed()
                        .collect(Collectors.toList()),
                iterator());

        return ResultOfGame.of(players, results.mapByIndex(indexMap));
    }

    public List<Integer> downToResult(List<Integer> indexMap, Iterator<Line> iterator) {
        if (!iterator.hasNext()) {
            return indexMap;
        }

        final Line line = iterator.next();
        return downToResult(line.move(indexMap), iterator);
    }

    @Override
    public String toString() {
        return "Ladder {" +
                super.toString() +
                "}";
    }
}
