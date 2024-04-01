package laddergame.domain.ladder;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.PlayersAndWinningContents;
import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(HeightOfLadder heightOfLadder, PlayersAndWinningContents playersAndWinningContents, LinkStrategy linkStrategy) {
        this.lines = Stream.generate(() -> Line.newLine(playersAndWinningContents, linkStrategy))
                .limit(heightOfLadder.height())
                .collect(Collectors.toList());
    }

    public static Ladder newLadder(HeightOfLadder heightOfLadder, PlayersAndWinningContents playersAndWinningContents, LinkStrategy linkStrategy) {
        return new Ladder(heightOfLadder, playersAndWinningContents, linkStrategy);
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
}
