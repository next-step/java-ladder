package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public final class Ladder {
    private static final int FIRST_INDEX = 0;

    private final List<LadderLine> ladderLines;

    public Ladder(final List<LadderLine> ladderLines) {
        validateLadderLines(ladderLines);
        this.ladderLines = ladderLines;
    }

    private void validateLadderLines(final List<LadderLine> ladderLines) {
        if (ladderLines == null) {
            throw new IllegalArgumentException("LadderLines can not be null");
        }
        if (ladderLines.isEmpty()) {
            throw new IllegalArgumentException("LadderLines can not be empty");
        }
    }

    public int getHeight() {
        return ladderLines.size();
    }

    public int getWidth() {
        return ladderLines.get(FIRST_INDEX).size();
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }
}
