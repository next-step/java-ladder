package ladder.domain.ladder;

import java.util.AbstractCollection;
import ladder.domain.Position;
import ladder.exception.ladder.EscapeLadderLinesException;
import ladder.exception.ladder.NoSuchLadderLineException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LadderLines {

    private static final int RESULT_START_NUMBER_MIN = 0;
    private final List<LadderLine> ladderLines;

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> ladderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public Position ladderClimbResultPosition(Position position) {
        if (isEscapePosition(position)) {
            throw new EscapeLadderLinesException();
        }
        return ladderClimbPosition(position);
    }

    private Position ladderClimbPosition(Position position) {
        Position currentPosition = position;
        for (LadderLine ladderLine : ladderLines) {
            currentPosition = ladderClimb(position, ladderLine);
        }
        return currentPosition;
    }

    private Position ladderClimb(Position position, LadderLine ladderLine) {
        List<HorizontalLineDirection> horizontalLineDirections = ladderLine.horizontalLineDirections();

        return position.descend(horizontalLineDirections.get(position.x()));
    }

    private boolean isEscapePosition(Position position) {
        return isInvalidLadderWidth(position.x()) && isInvalidLadderHeight(position.y());
    }

    private boolean isInvalidLadderHeight(int height) {
        return height < 0 || height >= ladderLines.size();
    }

    private boolean isInvalidLadderWidth(int width) {
        return width < RESULT_START_NUMBER_MIN || width >= ladderWidth();
    }

    private int ladderWidth() {
        return Optional.of(ladderLines.get(0))
                .orElseThrow(NoSuchLadderLineException::new)
                .width();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderLines that = (LadderLines) o;
        AbstractCollection<LadderLine> ladderLines = (AbstractCollection<LadderLine>) this.ladderLines;

        return ladderLines.equals(that.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
