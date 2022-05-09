package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int userCount;
    private final LadderLines ladderLines;

    public Ladder(int userCount, int ladderHeight, int range) {
        this.userCount = userCount;
        this.ladderLines = new LadderLines(IntStream.range(0, ladderHeight)
                .mapToObj(i -> new LadderLine(this.userCount, range))
                .collect(Collectors.toList()));
    }

    public List<LadderLine> getLadderLines() {
        return this.ladderLines.getLadderLines();
    }
}
