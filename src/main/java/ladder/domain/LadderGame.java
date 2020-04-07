package ladder.domain;

import java.util.List;

public class LadderGame {
    private final Users users;
    private final Ladder ladder;

    public static LadderGame of(String names, int height) {
        Users users = Users.of(names);
        return new LadderGame(users, Ladder.of(users, Height.of(height)));
    }

    private LadderGame(Users users, Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
    }

    public List<User> getUsers() {
        return users.getUsers();
    }

    public List<LadderLine> getLadder() {
        return ladder.getLadderLines();
    }

}
