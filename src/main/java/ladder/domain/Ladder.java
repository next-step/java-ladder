package ladder.domain;

import ladder.strategy.PointStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    private Ladder(final List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder of(final int height, final int countOfPerson, PointStrategy pointStrategy) {
        return IntStream.range(0, height)
                .mapToObj(i -> LadderLine.of(countOfPerson, pointStrategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Ladder::new));
    }

    public int getResultIndex(int startIndex) {
        int resultIndex = startIndex;
        for (LadderLine ladderLine : ladderLines) {
            resultIndex = ladderLine.move(resultIndex);
        }
        return resultIndex;
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladderLines=" + ladderLines +
                '}';
    }
}
