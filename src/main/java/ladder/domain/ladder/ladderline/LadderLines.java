package ladder.domain.ladder.ladderline;

import ladder.exception.ladder.EscapeLadderLinesException;
import ladder.exception.ladder.NoSuchLadderLineException;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LadderLines {

    private final List<LadderLine> ladderLines;
    private static final int RESULT_START_NUMBER_MIN = 0;

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> ladderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public Point result(Point position) {
        if (isEscapePosition(position)) {
            throw new EscapeLadderLinesException();
        }
        return ladderClimbResult(position);
    }

    private Point ladderClimbResult(Point position) {
        Point currentPosition = position;
        for (LadderLine ladderLine : ladderLines) {
            currentPosition = ladderClimb(position, ladderLine);
        }
        return currentPosition;
    }

    private Point ladderClimb(Point position, LadderLine ladderLine) {
        int x = ladderLine.horizontalLineDirections()
                .get(position.x)
                .move(position.x);
        return new Point(x, position.y + 1);
    }

    private boolean isEscapePosition(Point position) {
        return validLadderWidth(position.x) && validLadderHeight(position.y);
    }

    private boolean validLadderHeight(int height) {
        return height < 0 || height >= ladderLines.size();
    }

    private boolean validLadderWidth(int width) {
        return width < RESULT_START_NUMBER_MIN || width >= ladderWidth();
    }

    private int ladderWidth() {
        return Optional.of(ladderLines.get(0))
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
