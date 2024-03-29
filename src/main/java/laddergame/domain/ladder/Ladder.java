package laddergame.domain.ladder;

import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int START_RANGE = 0;

    private final List<Line> lines;

    private Ladder(int heightOfLadder, int numberOfPlayers, LinkStrategy linkStrategy) {
        this.lines = IntStream.range(START_RANGE, heightOfLadder)
                .mapToObj(i -> Line.newLine(numberOfPlayers, linkStrategy))
                .collect(Collectors.toList());
    }

    public static Ladder newLadder(int heightOfLadder, int numberOfPlayers, LinkStrategy linkStrategy) {
        return new Ladder(heightOfLadder, numberOfPlayers, linkStrategy);
    }

    public List<Line> lines() {
        return lines;
    }
}
