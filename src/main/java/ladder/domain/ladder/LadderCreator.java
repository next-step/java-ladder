package ladder.domain.ladder;

import ladder.domain.player.LadderPlayers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderCreator {
    private Lines lines;

    private LadderCreator(LineCount lineCount, LadderHeight ladderHeight) {
        this.lines = generateLadder(lineCount, ladderHeight);
    }

    public static LadderCreator create(LineCount lineCount, final LadderHeight ladderHeight) {
        return new LadderCreator(lineCount, ladderHeight);
    }

    private Lines generateLadder(LineCount lineCount, LadderHeight ladderMaxHeight) {
        List<Line> lineList = Stream
                .generate(() -> Line.createLine(lineCount))
                .limit(ladderMaxHeight.getHeight())
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
        return Lines.create(lineList);
    }

    public Lines getLines() {
        return lines;
    }
}
