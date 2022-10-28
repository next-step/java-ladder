package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.HorizontalLineDirection;
import ladder.exception.ladder.EscapeLadderLinesException;
import ladder.exception.ladder.NoSuchHorizontalLineDirectionException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLines {

    private final List<LadderLine> ladderLines;
    private static final int RESULT_START_NUMBER_MIN = 1;

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> ladderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public int result(int number) {
        if (isEscapeResultNumberBound(number)) {
            throw new EscapeLadderLinesException();
        }
        return ladderClimbResult(number);
    }

    private int ladderClimbResult(int number) {
        number = setStartResult(number);
        for (LadderLine ladderLine : ladderLines) {
            number = moveNumber(ladderLine.horizontalLineDirections().get(number), number);
        }
        return setEndResult(number);
    }

    private static int setEndResult(int number) {
        return number + 1;
    }

    private static int setStartResult(int number) {
        return number - 1;
    }

    private int moveNumber(HorizontalLineDirection horizontalLineDirection, int number) {
        if (horizontalLineDirection.equals(HorizontalLineDirection.LEFT)) {
            return number - 1;
        }
        if (horizontalLineDirection.equals(HorizontalLineDirection.RIGHT)) {
            return number + 1;
        }
        if (horizontalLineDirection.equals(HorizontalLineDirection.NONE)) {
            return number;
        }
        throw new NoSuchHorizontalLineDirectionException();
    }

    private boolean isEscapeResultNumberBound(int startNumber) {
        return startNumber < RESULT_START_NUMBER_MIN || startNumber > ladderWidth();
    }

    private int ladderWidth() {
        return ladderLines.get(0).horizontalLineDirections().size();
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
