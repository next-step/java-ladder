package ladder.domain.ladder.ladderline;

import java.util.stream.IntStream;
import ladder.domain.ladder.MoveHorizontalDirection;
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
        List<MoveHorizontalDirection> moveHorizontalDirections = ladderLine.horizontalLineDirections();

        return position.descend(moveHorizontalDirections.get(position.x()));
    }

    private boolean isEscapePosition(Position position) {
        return isValidLadderWidth(position.x()) && isValidLadderHeight(position.y());
    }

    private boolean isValidLadderHeight(int height) {
        return height < 0 || height >= ladderLines.size();
    }

    private boolean isValidLadderWidth(int width) {
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
