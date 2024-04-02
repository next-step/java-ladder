package laddergame.domain.ladder;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder newLadder(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder newLadder(HeightOfLadder heightOfLadder, PlayersAndWinningContents playersAndWinningContents, LinkStrategy linkStrategy) {
        List<Line> generatedLines = Stream.generate(() -> Line.newLine(playersAndWinningContents.numberOfLinks(), linkStrategy))
                .limit(heightOfLadder.height())
                .collect(Collectors.toList());

        return new Ladder(generatedLines);
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
}
