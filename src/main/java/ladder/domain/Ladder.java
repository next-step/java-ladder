package ladder.domain;

import ladder.strategy.PointStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(final int height, final int countOfPerson, PointStrategy pointStrategy) {
        return IntStream.range(0, height)
                .mapToObj(i -> Line.of(countOfPerson, pointStrategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Ladder::new));
    }

    public int getResultIndex(int startIndex) {
        int resultIndex = startIndex;
        for (Line line : lines) {
            resultIndex = line.move(resultIndex);
        }
        return resultIndex;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
