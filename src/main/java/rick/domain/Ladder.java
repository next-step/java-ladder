package rick.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import rick.strategy.LineCreationStrategy;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int countOfPerson, int ladderLineCount, LineCreationStrategy lineCreationStrategy) {
        lines = IntStream.range(0, ladderLineCount)
            .mapToObj(idx -> new Line(countOfPerson, lineCreationStrategy))
            .collect(Collectors.toList());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int rewardIndex(int playerIndex) {
        int currentPlayerIndex = playerIndex;
        for (Line line : lines) {
            currentPlayerIndex = line.nextPlayerIndex(currentPlayerIndex);
        }

        return currentPlayerIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
