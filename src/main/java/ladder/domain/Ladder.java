package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final List<LadderLine> ladderLines;

    public Ladder(int participantCount, LadderHeight ladderHeight) {
        this.ladderLines = IntStream.range(START_INDEX, ladderHeight.size())
                .mapToObj(index -> new LadderLine(participantCount, new RandomLadderGenerateStrategy()))
                .collect(Collectors.toList());
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
