package laddergame.game;

import laddergame.connectable.RandomConnection;
import laddergame.ladder.Height;
import laddergame.ladder.LadderLine;
import laddergame.ladder.LadderLines;
import laddergame.user.UserName;
import laddergame.user.UserNames;

import java.util.List;

public class LadderGame {
    private final UserNames userNames;
    private final LadderLines ladderLines;

    public LadderGame(UserNames userNames, Height height) {
        this.userNames = userNames;
        this.ladderLines = new LadderLines(height, userNames.length(), new RandomConnection());
    }

    public static LadderGame valueOf(String userNames, int height) {
        return new LadderGame(new UserNames(userNames), new Height(height));
    }

    public List<UserName> userNames() {
        return this.userNames.value();
    }

    public List<LadderLine> ladderLines() {
        return ladderLines.value();
    }
}
