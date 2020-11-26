package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.Preconditions.checkArgument;

public class LadderGame {
    public static String LADDER_HEIGHT_MUST_MORE_THEN_ONE = "ladder height must more then one";
    private final List<LadderLine> ladderLines;

    private LadderGame(final List<LadderLine> ladderLines) {
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public static LadderGame of(final String usersExpression, final int ladderHeight) {
        checkArgument(ladderHeight >= 1, LADDER_HEIGHT_MUST_MORE_THEN_ONE);
        final Users users = UsersGenerator.generate(usersExpression);
        final List<LadderLine> ladderLines = new ArrayList<>(ladderHeight);
        for (int i = 0; i < ladderHeight; i++) {
            final LadderLine ladderLine = LadderLine.of(users.size());
            ladderLines.add(ladderLine);
        }
        return new LadderGame(ladderLines);
    }
}
