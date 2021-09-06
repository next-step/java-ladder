package laddergame.game;

import laddergame.ladder.Height;
import laddergame.user.UserName;
import laddergame.user.UserNames;

import java.util.List;

public class LadderGame {

    private final Height height;
    private final UserNames userNames;

    public LadderGame(UserNames userNames, Height height) {
        this.userNames = userNames;
        this.height = height;
    }

    public static LadderGame valueOf(String userNames, int height) {
        return new LadderGame(new UserNames(userNames), new Height(height));
    }

    public List<UserName> userNames() {
        return this.userNames.value();
    }
}
