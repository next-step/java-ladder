package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final LadderHeight ladderHeight;
    private final LadderLines ladderLines;

    public Ladder(int userCount, LadderHeight ladderHeight) {
        this.ladderHeight = ladderHeight;
        this.ladderLines = new LadderLines(IntStream.range(0, ladderHeight.getHeight())
                .mapToObj(i -> new LadderLine(LadderLineGenerator.generate(userCount -1)))
                .collect(Collectors.toList()));
    }

    public List<LadderLine> getLadderLines() {
        return this.ladderLines.getLadderLines();
    }

}
