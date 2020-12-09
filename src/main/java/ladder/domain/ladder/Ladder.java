package ladder.domain.ladder;

import ladder.domain.util.RandomStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfPlayer, int ladderSize, RandomStrategy randomStrategy) {
        this.lines = IntStream.range(0, ladderSize)
                .mapToObj(i -> new Line(countOfPlayer, randomStrategy))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getResultIndexByPlayerIndex(int playerIndex) {
        int index = playerIndex;
        for (Line line : lines) {
            index = line.movePoint(index);
        }
        return index;
    }
}
