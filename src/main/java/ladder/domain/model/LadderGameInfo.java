package ladder.domain.model;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.user.Users;

public class LadderGameInfo {

    private final Users users;
    private final LadderHeight ladderHeight;

    public LadderGameInfo(Users users, LadderHeight ladderHeight) {
        this.users = users;
        this.ladderHeight = ladderHeight;
    }

    public Users getUsers() {
        return users;
    }

    public LadderHeight getLadderHeight() {
        return ladderHeight;
    }
}
