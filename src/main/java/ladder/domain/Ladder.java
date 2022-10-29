package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<VerticalLine> lines;
    private final LadderLength ladderLength;

    public Ladder(List<VerticalLine> lines, LadderLength ladderLength) {
        this.lines = lines;
        this.ladderLength = ladderLength;
    }

    public List<Position> play(List<Position> positions) {
        return positions.stream()
                .map((position) -> this.move(new LadderPosition(position)))
                .collect(Collectors.toList());
    }

    private Position move(LadderPosition ladderPosition) {
        while (!ladderPosition.isArrived(this.ladderLength)) {
            VerticalLine verticalLine = findVerticalLineByPosition(ladderPosition.getHorizontalPosition());
            verticalLine.move(ladderPosition);
        }
        return ladderPosition.getHorizontalPosition();
    }

    private VerticalLine findVerticalLineByPosition(Position position) {
        return this.lines.stream()
                .filter((line) -> line.isSamePosition(position))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    public List<VerticalLine> getLines() {
        return lines;
    }

    public LadderLength getLadderLength() {
        return ladderLength;
    }


}
