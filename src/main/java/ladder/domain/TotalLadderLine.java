package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.Preconditions.checkArgument;

public class TotalLadderLine {
    private static final int MINIMUM_LADDER_HEIGHT = 1;
    public static String LADDER_HEIGHT_MUST_MORE_THEN_ONE = "ladder height must more then one";
    private final List<LadderLine> ladderLines;

    public TotalLadderLine(final List<LadderLine> ladderLines) {
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public static TotalLadderLine of(final int userCount, final int ladderHeight) {
        checkArgument(ladderHeight >= MINIMUM_LADDER_HEIGHT, LADDER_HEIGHT_MUST_MORE_THEN_ONE);
        final List<LadderLine> ladderLines = new ArrayList<>(ladderHeight);
        for (int i = 0; i < ladderHeight; i++) {
            final LadderLine ladderLine = LadderLine.of(userCount);
            ladderLines.add(ladderLine);
        }
        return new TotalLadderLine(ladderLines);
    }

    public int size() {
        return ladderLines.size();
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
