package ladder.domain.ladder.ladderline;

import ladder.exception.ladder.EscapeLadderLinesException;
import ladder.exception.ladder.NoSuchLadderLineException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLines {

    private final List<LadderLine> ladderLines;
    private static final int RESULT_START_NUMBER_MIN = 0;

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> ladderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public int result(int startNumber) {
        if (isEscapeResultNumberBound(startNumber)) {
            throw new EscapeLadderLinesException();
        }
        return ladderClimbResult(startNumber);
    }

    private int ladderClimbResult(int startNumber) {
        int result = startNumber;
        for (LadderLine ladderLine : ladderLines) {
            result = ladderLine.horizontalLineDirections()
                    .get(result)
                    .move(result);
        }
        return result;
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
