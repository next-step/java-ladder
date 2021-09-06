package laddergame.game;

import laddergame.ladder.Height;
import laddergame.ladder.LadderLines;
import laddergame.user.UserName;
import laddergame.user.UserNames;

import java.util.List;

public class LadderGame {
    private final UserNames userNames;
    private final LadderLines ladderLines;

    public LadderGame(UserNames userNames, Height height) {
        this.userNames = userNames;
        this.ladderLines = new LadderLines(height);
    }

    public static LadderGame valueOf(String userNames, int height) {
        return new LadderGame(new UserNames(userNames), new Height(height));
    }

    public List<UserName> userNames() {
        return this.userNames.value();
    }

    public LadderLines ladderLines() {
        return ladderLines;
    }
}
