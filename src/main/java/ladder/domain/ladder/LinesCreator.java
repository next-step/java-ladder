package ladder.domain.ladder;

import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.ladder.ladderInfo.LineCount;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LinesCreator {

    public static Lines create(LineCount lineCount, final LadderHeight ladderHeight) {
        return createLadderLines(lineCount, ladderHeight);
    }

    private static Lines createLadderLines(LineCount lineCount, LadderHeight ladderMaxHeight) {
        List<Line> lines = Stream.iterate(0, i -> i < ladderMaxHeight.getHeight(), i -> i + 1)
                .map(i -> LineCreator.create(lineCount))
                .collect(toList());
        return new Lines(lines, lineCount);
    }
}
