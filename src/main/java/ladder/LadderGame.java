package ladder;

import java.util.Collections;
import java.util.List;

public class LadderGame {
    private final List<LadderLine> ladderLines;

    private LadderGame(final List<LadderLine> ladderLines) {
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public static LadderGame of(final String usersExpression, final int ladderHeight) {
        return new LadderGame(Collections.emptyList());
    }
}
