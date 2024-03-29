package laddergame.domain.ladder;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(HeightOfLadder heightOfLadder, int numberOfPlayers, LinkStrategy linkStrategy) {
        this.lines = IntStream.range(0, heightOfLadder.height())
                .mapToObj(i -> Line.newLine(numberOfPlayers, linkStrategy))
                .collect(Collectors.toList());
    }

    public static Ladder newLadder(HeightOfLadder heightOfLadder, int numberOfPlayers, LinkStrategy linkStrategy) {
        return new Ladder(heightOfLadder, numberOfPlayers, linkStrategy);
    }

    public List<Line> lines() {
        return lines;
    }
}
