package nextstep.domain;

import java.util.List;

public class StartLadderGame {
    private final Users users;
    private final Ladder ladder;

    public StartLadderGame(Users users, LadderHeight ladderHeight) {
        this.users = users;
        this.ladder = new Ladder(users.getUserSize(), ladderHeight);
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public List<User> getUsers() {
        return this.users.getUsers();
    }

}
