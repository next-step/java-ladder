package ladder.domain.ladder;

import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.ladder.ladderInfo.LineCount;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LinesCreator {

    public static Lines create(int playerCount, final LadderHeight ladderHeight) {
        return createLadderLines(playerCount, ladderHeight);
    }

    private static Lines createLadderLines(int playerCount, LadderHeight ladderMaxHeight) {
        List<Line> lines = Stream.iterate(0, i -> i < ladderMaxHeight.getHeight(), i -> i + 1)
                .map(i -> LineCreator.create(playerCount))
                .collect(toList());
        return new Lines(lines, playerCount);
    }
}
