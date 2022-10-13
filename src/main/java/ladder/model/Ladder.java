package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<VerticalLine> lines;
    private final LadderLength ladderLength;

    public Ladder(List<VerticalLine> lines, LadderLength ladderLength) {
        this.lines = lines;
        this.ladderLength = ladderLength;
    }

    public List<LadderPosition> play(List<Integer> startPositions) {
        return startPositions.stream().map(this::play).collect(Collectors.toList());
    }

    LadderPosition play(int startPosition) {
        LadderPosition ladderPosition = new LadderPosition(startPosition);
        while (!ladderPosition.isArrived(this.ladderLength)) {
            VerticalLine verticalLine = this.lines.get(ladderPosition.getHorizontalPosition());
            verticalLine.play(ladderPosition);
        }
        return ladderPosition;
    }

    public List<VerticalLine> getLines() {
        return lines;
    }

    public LadderLength getLadderLength() {
        return ladderLength;
    }


}
