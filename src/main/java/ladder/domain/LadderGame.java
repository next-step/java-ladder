package ladder.domain;

import java.util.List;

public class LadderGame {
    private final Users users;
    private final Ladder ladder;

    public LadderGame(String users, LadderHeight ladderHeight) {
        this.users = new Users(users);
        this.ladder = new Ladder(this.users.getUsersSize(), ladderHeight.getHeight());
    }

    public List<User> getUnmodifiableUsers() {
        return users.unmodifiableUsers();
    }

    public List<Line> getUnmodifiableLadderLines() {
        return ladder.getUnmodifiableLadderLines();
    }
}
