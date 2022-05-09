package nextstep.domain;

import java.util.List;

public class StartLadderGame {
    private static final int RANGE = 2;
    private final List<User> users;
    private final LadderHeight maxLadderHeight;
    private final Ladder ladder;

    public StartLadderGame(List<User> users, LadderHeight ladderHeight) {
        this.users = users;
        this.maxLadderHeight = ladderHeight;
        this.ladder = new Ladder(users.size(), ladderHeight.getHeight(), RANGE);
    }

    public List<LadderLine> getLadderLines() {
        return ladder.getLadderLines();
    }

    public List<User> getUsers() {
        return users;
    }
}
