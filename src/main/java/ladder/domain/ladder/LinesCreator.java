package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LinesCreator {
    private Lines lines;

    private LinesCreator(LineCount lineCount, LadderHeight ladderHeight) {
        this.lines = generateLadder(lineCount, ladderHeight);
    }

    public static LinesCreator create(LineCount lineCount, final LadderHeight ladderHeight) {
        return new LinesCreator(lineCount, ladderHeight);
    }

    private Lines generateLadder(LineCount lineCount, LadderHeight ladderMaxHeight) {
        List<Line> lines = Stream
                .generate(() -> Line.createLine(lineCount))
                .limit(ladderMaxHeight.getHeight())
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
        return Lines.create(lines);
    }

    public Lines getLines() {
        return lines;
    }
}
