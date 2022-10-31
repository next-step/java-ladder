package ladder.domain.ladder.ladderline;

import ladder.exception.ladder.EscapeLadderLinesException;
import ladder.exception.ladder.NoSuchLadderLineException;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLines {

    private static final int RESULT_START_NUMBER_MIN = 0;
    private final List<LadderLine> ladderLines;

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> ladderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public Point result(Point point) {
        if (isEscapeResultNumberBound(point.x)) {
            throw new EscapeLadderLinesException();
        }
        return ladderClimbResult(point);
    }

    private Point ladderClimbResult(Point position) {
        Point currentPosition = position;
        for (LadderLine ladderLine : ladderLines) {
            int x = ladderLine.horizontalLineDirections()
                    .get(position.x)
                    .move(position.x);
            currentPosition = new Point(x, position.y + 1);
        }
        return currentPosition;
    }

    private boolean isEscapeResultNumberBound(int startNumber) {
        return startNumber < RESULT_START_NUMBER_MIN || startNumber > ladderWidth();
    }

    private int ladderWidth() {
        return ladderLines.stream()
                .findFirst()
                .orElseThrow(NoSuchLadderLineException::new)
                .width();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLines that = (LadderLines) o;
        return Objects.equals(ladderLines, that.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
