package laddergame.domain;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Users users;

    public LadderGame(String nameString, int maxLadderHeight) {
        users = new Users(nameString);
        ladder = new Ladder(maxLadderHeight, users.getUserCount());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public String getUserNames() {
        return users.getUserNames();
    }
}
