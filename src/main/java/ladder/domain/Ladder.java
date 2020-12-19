package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final List<LadderLine> ladderLines;

    public Ladder(LadderSize ladderSize) {
        this.ladderLines = IntStream.range(START_INDEX, ladderSize.getHeight())
                .mapToObj(index -> new LadderLine(ladderSize.getWidth()))
                .collect(Collectors.toList());
    }

    public int getLastPosition(int startPosition) {
        int lastPosition = startPosition;
        for (LadderLine line : ladderLines) {
            lastPosition = line.move(lastPosition);
        }
        return lastPosition;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public int getLadderWidth() {
        return ladderLines.get(0).getPoints().size();
    }
}
