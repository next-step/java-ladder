package ladder.domain.ladder.ladderline;

import java.util.stream.IntStream;
import ladder.domain.ladder.HorizontalLineDirection;
import ladder.domain.person.Position;
import ladder.exception.ladder.EscapeLadderLinesException;
import ladder.exception.ladder.NoSuchLadderLineException;

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

    public Position result(Position position) {
        if (isEscapePosition(position)) {
            throw new EscapeLadderLinesException();
        }
        return ladderClimbResult(position);
    }

    private Position ladderClimbResult(Position position) {
        Position currentPosition = position;
        for (LadderLine ladderLine : ladderLines) {
            currentPosition = ladderClimb(position, ladderLine);
        }
        return currentPosition;
    }

    private Position ladderClimb(Position position, LadderLine ladderLine) {
        HorizontalLineDirection horizontalLineDirection = ladderLine.horizontalLineDirections().get(position.x());
        return position.descend(horizontalLineDirection);
    }

    private boolean isEscapePosition(Position position) {
        return validLadderWidth(position.x()) && validLadderHeight(position.y());
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderLines that = (LadderLines) o;
        long count = IntStream.range(0, this.ladderLines.size())
                .filter(index -> !(this.ladderLines.get(index).equals(that.ladderLines.get(index))))
                .count();

        return count == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
